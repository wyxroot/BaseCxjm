package com.foresee.ss.dsp.auto.vo;

import com.google.gson.JsonArray;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
    结果集封装实体
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-01 19:11
 */
public class ResultVO<T> implements Serializable {

    private List<T> insertMsg;

    private List<T> updateMsg;

    private List<T> deleteMsg;

    public List<T> getDeleteMsg() {
        return deleteMsg;
    }

    public void setDeleteMsg(List<T> deleteMsg) {
        this.deleteMsg = deleteMsg;
    }

    public List<T> getInsertMsg() {
        return insertMsg;
    }

    public void setInsertMsg(List<T> insertMsg) {
        this.insertMsg = insertMsg;
    }

    public List<T> getUpdateMsg() {
        return updateMsg;
    }

    public void setUpdateMsg(List<T> updateMsg) {
        this.updateMsg = updateMsg;
    }
}
