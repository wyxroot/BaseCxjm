package com.foresee.ss.dsp.rest.controller.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxx;
import com.foresee.ss.dsp.auto.vo.CxjmyzPLVO;

/**
 * 功能联调、性能测试接口
 *
 * @author chenqiang@foresee.com.cn
 * @create 2018-11-06
 */
@RestController
@RequestMapping("/v1/batch/demo")
public class DemoController {

    @PostMapping("/saveOrUpdate")
    public Response saveOrUpdate(@RequestBody CxjmyzPLVO<SfzjCxjmyzxx> cxjmyzPLVO) {
        if (cxjmyzPLVO == null) {
            return new Response("999", "无数据");
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Response.successData(cxjmyzPLVO);
    }
}
