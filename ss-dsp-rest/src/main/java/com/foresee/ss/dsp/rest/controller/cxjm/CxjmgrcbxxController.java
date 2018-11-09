package com.foresee.ss.dsp.rest.controller.cxjm;

import com.foresee.ss.dsp.rest.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import com.foresee.ss.dsp.auto.vo.CxjmxxVO;
import com.foresee.ss.dsp.service.cxjm.CxjmgrcbxxService;

/**
 * 描述:
 * 城乡居民个人参保信息
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-01 9:20
 */
@RestController
@RequestMapping("/v1/insurInfo")
public class CxjmgrcbxxController extends BaseController<SfzjCxjmgrcbxx> {

    @Autowired
    private CxjmgrcbxxService cxjmgrcbxxService;

    @PostMapping("/saveOrUpdate")
    public Response insert(@RequestBody CxjmxxVO<SfzjCxjmgrcbxx> cxjmgrcbxxVO) {
        return super.saveOrUpdate(cxjmgrcbxxVO);
    }
}
