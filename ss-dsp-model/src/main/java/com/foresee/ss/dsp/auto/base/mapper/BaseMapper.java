package com.foresee.ss.dsp.auto.base.mapper;


/**
 * 描述:
 *
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 14:21
 */
public interface BaseMapper<T> {
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
    int insert(T record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(T record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param xh
     */
    T selectByPrimaryKey(String xh);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(T record);

    /**
     * 调用存储过程
     * @param model
     */
    void procedure(T model);

}
