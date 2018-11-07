package com.foresee.ss.dsp.rest.controller.cxjm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.base.dto.BaseDto;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrjcxx;
import com.foresee.ss.dsp.auto.vo.CxjmxxVO;
import com.foresee.ss.dsp.rest.controller.base.BaseController;
import com.foresee.ss.dsp.service.cxjm.CxjmgrjcxxService;

/**
 * 描述:
 * 城乡居民个人基础信息控制层
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 11:17
 */
@RestController
@RequestMapping("/v1/personalInfo/")
public class CxjmgrjcxxController extends BaseController<SfzjCxjmgrjcxx,BaseDto> {

    @Autowired
    private CxjmgrjcxxService cxjmgrjcxxService;

    @PostMapping("/saveOrUpdate")
    public Response saveOrUpdate(@RequestBody CxjmxxVO<SfzjCxjmgrjcxx, BaseDto> cxjmgrcbxxVO){
       return super.saveOrUpdate(cxjmgrcbxxVO);
    }
}
