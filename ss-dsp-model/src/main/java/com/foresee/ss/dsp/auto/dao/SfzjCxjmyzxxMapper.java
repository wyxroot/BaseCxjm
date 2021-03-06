package com.foresee.ss.dsp.auto.dao;

import com.foresee.ss.dsp.auto.dto.CbxxProcdure;
import com.foresee.ss.dsp.auto.dto.CxjmPLCriteriaDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmPLResultMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxx;

import java.util.List;

public interface SfzjCxjmyzxxMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param xh
     */
    int deleteByPrimaryKey(String xh);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(SfzjCxjmyzxx record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(SfzjCxjmyzxx record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param xh
     */
    SfzjCxjmyzxx selectByPrimaryKey(String xh);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SfzjCxjmyzxx record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SfzjCxjmyzxx record);

    /**
     * 保存数据并调用存储过程
     *
     * @param sfzjCxjmyzxx
     */
    void procedure(SfzjCxjmyzxx sfzjCxjmyzxx);

    /**
     * 批量新增数据
     *
     * @param insertList
     */
    void batchInsert(List<SfzjCxjmyzxx> insertList);

    /**
     * 根据批次号查询数据
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