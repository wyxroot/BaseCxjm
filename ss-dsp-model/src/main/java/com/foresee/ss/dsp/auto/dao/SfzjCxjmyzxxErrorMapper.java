package com.foresee.ss.dsp.auto.dao;


import com.foresee.ss.dsp.auto.dto.CxjmPLCriteriaDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmPLResultMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxxError;

import java.util.List;

public interface SfzjCxjmyzxxErrorMapper {
    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(SfzjCxjmyzxxError record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(SfzjCxjmyzxxError record);

    /**
     * 批量新增错误数据
     *
     * @param jcxmyzErrorList
     */
    void batchInsertErrorData(List<SfzjCxjmyzxxError> jcxmyzErrorList);

    /**
     * 根据批次号批量查询数据
     *
     * @param cspch
     * @return
     */
    List<CxjmPLResultMsg> findByCspch(String cspch);

    /**
     * 根据条件批量查询保存数据
     *
     * @param criteriaDto
     * @return
     */
    List<CxjmPLResultMsg> findByCriteria(CxjmPLCriteriaDto criteriaDto);
}