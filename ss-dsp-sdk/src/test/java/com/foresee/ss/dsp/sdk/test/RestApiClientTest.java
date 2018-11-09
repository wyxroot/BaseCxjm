/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */
package com.foresee.ss.dsp.sdk.test;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.foresee.icap.framework.entity.api.Request;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.open.sdk.json.JsonKit;
import com.foresee.open.sdk.kit.ResourceUtils;
import com.foresee.open.sdk.kit.ZipUtil;
import com.foresee.ss.dsp.sdk.rest.RestApiClient;

/**
 * <pre>
 * REST接口测试类
 * </pre>
 *
 * @author chenqiang@foresee.com.cn
 * @date 2018年11月8日
 * @version 1.00.00
 */

public class RestApiClientTest {

    private static Logger              logger    = LoggerFactory.getLogger(RestApiClientTest.class);

    private static Integer             count     = 0;

    private static Map<String, String> idMaps    = new ConcurrentHashMap<String, String>();

    private static Map<String, String> allIdMaps = new ConcurrentHashMap<String, String>();

    private static String              server    = "http://10.10.4.66:8899";

    private static int                 threads   = 1;

    private static int                 loops     = 100;


    public static void main(String[] args) throws IOException {

        if (System.getProperty("server") != null) {
            server = System.getProperty("server").trim();
        }

        if (System.getProperty("threads") != null) {
            threads = Integer.parseInt(System.getProperty("threads").trim());
        }

        if (System.getProperty("loops") != null) {
            loops = Integer.parseInt(System.getProperty("loops").trim());
        }

        logger.debug("Begin with server: {}, threads: {}, loops: {}", server, threads, loops);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        count = 0;

        final String data = ResourceUtils.getFileContentFromClassPath(RestApiClientTest.class, "data.json");

        logger.info("Load test data: {}", data);

        ThreadPoolExecutor dispatcherPool = new ThreadPoolExecutor(20, 50, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
                new ThreadFactory() {

                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r); //自定义线程名称
                        t.setDaemon(true); //守护线程
                        return t;
                    }

                });

        for (int i = 0; i < threads; i++) {
            dispatcherPool.submit(new Runnable() {

                public void run() {
                    try {
                        send(data, loops, false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
        }

        while (count < threads * loops) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logger.info("Finish.");
    }

    private static void send(String data, int times, boolean zip) throws IOException {
        RestApiClient client = new RestApiClient(server, "00000001", "00000003", "mWWfBi37ayGJqMY3", null, "1.0");

        for (int i = 0; i < times; i++) {
            long time = System.currentTimeMillis();
            Request request = JsonKit.fromJson(data, Request.class);
            String body = JsonKit.toString(request.getBody());

            String id = UUID.randomUUID().toString().replaceAll("-", "");
            body = String.format(body, id);
            if (zip) {
                body = ZipUtil.compress(body, true);
            }

            try {
                idMaps.put(id, Thread.currentThread().getId() + "_" + i);
                logger.info(String.format("q: %d-%d=%s -- %s", Thread.currentThread().getId(), i, id, idMaps));

                try {
                    Response response = client.invoke("v1/batch/demo/saveOrUpdate", body, id, id);
                } catch (Exception e) {
                    logger.error("调用接口失败：{}", e.getMessage(), e);
                }

                idMaps.remove(id);
                time = System.currentTimeMillis() - time;
                logger.info(String.format("r: %d-%d=%s,%d -- %s", Thread.currentThread().getId(), i, id, time, idMaps));

            } finally {
                idMaps.remove(id);
            }
            synchronized ("1".intern()) {
                allIdMaps.put(id, id);
                count++;
                logger.info("c: " + count + "=" + allIdMaps.size());
            }
            //            request.setBody(body);
            //            request.getHead().setRequestId(id);
            //KafkaProducerClient.getInstance("", "").send("QL_GWTOSW_SSYW_GW", JsonKit.toString(request));
        }

    }

}
