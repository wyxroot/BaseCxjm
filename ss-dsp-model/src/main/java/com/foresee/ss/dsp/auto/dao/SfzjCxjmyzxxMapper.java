package com.foresee.ss.dsp.auto.dao;

import com.foresee.ss.dsp.auto.dto.CbxxProcdure;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxx;

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
     * @param sfzjCxjmyzxx
     */
    void procedure(SfzjCxjmyzxx sfzjCxjmyzxx);
}