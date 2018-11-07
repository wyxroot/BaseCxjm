package com.foresee.ss.dsp.auto.dao;

import com.foresee.ss.dsp.auto.model.SfzjCxjmxnhjcxx;

public interface SfzjCxjmxnhjcxxMapper {
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
    int insert(SfzjCxjmxnhjcxx record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(SfzjCxjmxnhjcxx record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param xh
     */
    SfzjCxjmxnhjcxx selectByPrimaryKey(String xh);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SfzjCxjmxnhjcxx record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SfzjCxjmxnhjcxx record);
}