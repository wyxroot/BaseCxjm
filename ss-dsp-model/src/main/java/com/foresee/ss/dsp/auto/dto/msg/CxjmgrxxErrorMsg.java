package com.foresee.ss.dsp.auto.dto.msg;

import com.google.gson.JsonArray;

/**
 * 描述:
 * 两居个人基础信息交换错误信息实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-01 19:46
 */
public class CxjmgrxxErrorMsg<T> {

    /**
     * 异常码
     */
    private int errorCode;

    /**
     * 异常信息
     */
    private String errorMsg;


    /**
     * 序号
     */
    private String xh;

    /**
     * 证件号码
     */
    private String zjhm;

    /**
     * 姓名
     */
    private String xm;

    /**
     * 个人编号
     */
    private String grbh;

    /**
     * 异常对象
     * @return
     */
    private T fkxx;

    public T getFkxx() {
        return fkxx;
    }

    public void setFkxx(T fkxx) {
        this.fkxx = fkxx;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getGrbh() {
        return grbh;
    }

    public void setGrbh(String grbh) {
        this.grbh = grbh;
    }
}
