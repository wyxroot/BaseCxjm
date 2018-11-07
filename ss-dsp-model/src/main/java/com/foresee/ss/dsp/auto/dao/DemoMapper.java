package com.foresee.ss.dsp.auto.dao;

import com.foresee.ss.dsp.auto.model.DemoDto;

public interface DemoMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(DemoDto record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(DemoDto record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    DemoDto selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(DemoDto record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(DemoDto record);


}