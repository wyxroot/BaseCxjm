/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */
package com.foresee.ss.dsp.sdk.rest;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.open.sdk.client.OpenApiClient;
import com.foresee.open.sdk.json.Jackson;

/**
 * <pre>
 * REST接口调用客户端
 * </pre>
 *
 * @author chenqiang@foresee.com.cn
 * @date 2018年11月8日
 * @version 1.00.00
 */

public class RestApiClient {

    private static final Logger logger = LoggerFactory.getLogger(RestApiClient.class);

    private String              server;

    private String              providerAppId;

    private String              clientVersion;

    private String              encoding;

    private OpenApiClient       openApiClient;


    /**
     * 创建一个REST接口的调用客户端
     * @param server 服务器地址，格式如：https://{IP或域名}:{端口}/{上下文}
     * @param consumerAppId 消费方（各地市或对接产商）应用ID
     * @param providerAppId 提供方（社保数据交换平台）应用ID
     * @param signKey 签名秘钥
     * @param encoding 编码，仅支持gzip压缩，如果设置为gzip，则后续调invoke方法时传入的body必须是gzip压缩并做Base64转码的字符串
     * @param clientVersion 客户端版本，填写接口文档的版本号如"1.0"
     */
    public RestApiClient(String server, String consumerAppId, String providerAppId, String signKey, String encoding,
            String clientVersion) {
        super();
        this.server = server;
        this.providerAppId = providerAppId;
        this.encoding = encoding;
        this.clientVersion = clientVersion;

        openApiClient = new OpenApiClient(consumerAppId, signKey);
    }

    /**
     * 调用接口
     * @param api 接口的路径，如：v1/batch/taxInfo/saveOrUpdate，注意前后不能有斜杆
     * @param body 业务报文，如果创建RestApiClient时指定了encoding（gzip），body也必须做相应的gzip压缩
     * @return Response 响应报文体，通过getHead、getBody可分别获取到响应头与业务数据
     */
    public Response invoke(String api, String body) {
        return this.invoke(api, body, null, null);
    }

    /**
     * 调用接口，可指定请求ID与会话ID
     * @param api 接口的路径，如：v1/batch/taxInfo/saveOrUpdate，注意前后不能有斜杆
     * @param body 业务报文，如果创建RestApiClient时指定了encoding（gzip），body也必须做相应的gzip压缩
     * @param requestId 请求ID，长度为32，调用方可自行生成用于跟踪请求调用链路，需要确保全局唯一，建议使用UUID算法生成，为空时SDK自动生成。
     * @param sessionId 会话ID，长度为32，调用方可自行生成用于跟踪若干相关请求（例如一个批次的多次接口调用）的调用链路，需要确保全局唯一，建议使用UUID算法生成，为空时SDK自动生成。
     * @return Response 响应报文体，通过getHead、getBody可分别获取到响应头与业务数据
     */
    public Response invoke(String api, String body, String requestId, String sessionId) {

        // 构造URL
        StringBuffer url = genUrl(api, requestId, sessionId);

        logger.debug("Request begin, url:[{}], body:[{}]", url.toString(), body);

        Response response;
        try {
            String responseJson = openApiClient.requestApp(url.toString(), body, providerAppId);
            response = Jackson.fromJson(responseJson, Response.class);
        } catch (Exception e) {
            logger.error("Request error: {}", e.getMessage(), e);
            response = Response.error("00011101", "调用接口异常：" + e.getMessage());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Response: {}", Jackson.toJson(response));
        }

        return response;
    }

    /**
     * 生成调用的URL
     */
    private StringBuffer genUrl(String api, String requestId, String sessionId) {
        StringBuffer url = new StringBuffer(this.server).append("/").append(api);
        Map<String, String> params = new HashMap<String, String>();
        if (requestId != null) {
            params.put("requestId", requestId);
        }
        if (sessionId != null) {
            params.put("sessionId", sessionId);
        }
        if (clientVersion != null) {
            params.put("encoding", encoding);
        }
        if (clientVersion != null) {
            params.put("clientVersion", clientVersion);
        }

        if (!params.isEmpty()) {
            url.append("?");
            for (String param : params.keySet()) {
                url.append(param).append("=").append(params.get(param)).append("&");
            }
            url.deleteCharAt(url.length() - 1);
        }
        return url;
    }

}
