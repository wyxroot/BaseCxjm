package com.foresee.ss.dsp.rest.controller.cxjm;

import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.dto.CxjmPLCriteriaDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmPLResultMsg;
import com.foresee.ss.dsp.service.cxjm.CxjmPLJGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 * 城乡居民批量应征查询结果控制层
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-09 15:32
 */
@RestController
@RequestMapping("/v1/batch/taxInfoResults")
public class CxjmPLJGController {

    @Autowired
    private CxjmPLJGService cxjmPLJGService;

    @PostMapping("/query")
    public Response query(@RequestBody CxjmPLCriteriaDto criteriaDto) {

        if (criteriaDto == null) {
            return null;
        }

        List<CxjmPLResultMsg> resultMsgs = cxjmPLJGService.query(criteriaDto);
        return Response.success("200", resultMsgs);
    }
}
