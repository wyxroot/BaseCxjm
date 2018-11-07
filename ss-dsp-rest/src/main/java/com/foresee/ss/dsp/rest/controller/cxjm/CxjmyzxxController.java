package com.foresee.ss.dsp.rest.controller.cxjm;

import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgeyzMsg;
import com.foresee.ss.dsp.auto.vo.CxjmyzVO;
import com.foresee.ss.dsp.service.cxjm.CxjmyzxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 * 城乡居民应征信息交换接口
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 15:45
 */
@RestController
@RequestMapping("/v1/taxInfo")
public class CxjmyzxxController {

    @Autowired
    private CxjmyzxxService cxjmyzxxService;

    @PostMapping("/saveOrUpdate")
    public Response saveOrUpdate(@RequestBody List<CxjmyzVO> cxjmyzVO){
        if (cxjmyzVO == null || cxjmyzVO.size() == 0){
            return null;
        }

        List<CxjmgeyzMsg> errorList = cxjmyzxxService.checkAndSave(cxjmyzVO);

        return  Response.success(null,errorList);
    }
}
