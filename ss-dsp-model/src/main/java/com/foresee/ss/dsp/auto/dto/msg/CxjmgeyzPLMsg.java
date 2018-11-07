package com.foresee.ss.dsp.auto.dto.msg;


/**
 * 描述:
 * 城乡居民个人应征 消息实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-02 10:47
 */
public class CxjmgeyzPLMsg<T> {

    /**
     * 状态码 ‘0’-成功，‘2’-失败
     */
    private int  returnCode;

    /**
     * 异常信息
     */
    private String returnMsg;

    /**
     * 异常数据
     */
    private T fkxx;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getFkxx() {
        return fkxx;
    }

    public void setFkxx(T fkxx) {
        this.fkxx = fkxx;
    }
}
