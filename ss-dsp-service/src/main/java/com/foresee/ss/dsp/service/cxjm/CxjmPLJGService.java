package com.foresee.ss.dsp.service.cxjm;

import com.foresee.ss.dsp.auto.dto.CxjmPLCriteriaDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmPLResultMsg;

import java.util.List;

/**
 * 描述:
 * 城乡居民批量结果查询业务层接口
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-09 15:46
 */
public interface CxjmPLJGService {

    /**
     * 根据查询条件查询批量数据
     *
     * @param criteriaDto
     * @return
     */
    List<CxjmPLResultMsg> query(CxjmPLCriteriaDto criteriaDto);
}
