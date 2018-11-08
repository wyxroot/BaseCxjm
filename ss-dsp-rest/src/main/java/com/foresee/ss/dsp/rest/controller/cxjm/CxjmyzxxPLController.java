package com.foresee.ss.dsp.rest.controller.cxjm;

import java.util.List;

import com.foresee.icap.framework.core.api.annotation.Api;
import com.foresee.icap.framework.core.api.annotation.ApiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgeyzPLMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxx;
import com.foresee.ss.dsp.auto.vo.CxjmyzPLVO;
import com.foresee.ss.dsp.auto.vo.ResultVO;
import com.foresee.ss.dsp.service.cxjm.CxjmyzxxPLService;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 * 城乡居民应征信息控制器
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-02 9:50
 */
@RestController
@RequestMapping("/v1/batch/taxInfo")
public class CxjmyzxxPLController {

    @Autowired
    private CxjmyzxxPLService cxjmyzxxPLService;

    @PostMapping("/saveOrUpdate")
    public Response saveOrUpdate(@RequestBody CxjmyzPLVO<SfzjCxjmyzxx> cxjmyzPLVO){
        if (cxjmyzPLVO == null){
            return new Response("999","无数据");
        }

        ResultVO<CxjmgeyzPLMsg> failData = new ResultVO<>();

        /**
         * check and save
         */
        List<CxjmgeyzPLMsg> errorList = cxjmyzxxPLService.checkAndSave(cxjmyzPLVO);
        //先留着返回,方便查看失败数据, 后期删除
        failData.setInsertMsg(errorList);

        cxjmyzxxPLService.saveErrorData(cxjmyzPLVO.getCspch(),errorList);

        return  Response.success(null,failData.getInsertMsg());
    }
}












