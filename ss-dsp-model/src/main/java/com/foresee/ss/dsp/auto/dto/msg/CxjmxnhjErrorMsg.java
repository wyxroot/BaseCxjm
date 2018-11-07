package com.foresee.ss.dsp.auto.dto.msg;

/**
 * 描述:
 * 城乡居民虚拟户信息交换错误信息实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 20:23
 */
public class CxjmxnhjErrorMsg<T> {

    /**
     * 异常状态码
     */
    private String returnCode;

    /**
     * 异常信息
     */
    private String returnMsg;

    /**
     * 异常数据
     */
    private T fkxx;

    /**
     * 序号
     */
    private String xh;

    /**
     * 单位编号
     */
    private String dwbh;

    /**
     * 单位名称
     */
    private String dwmc;

    /**
     * 社保经办机构
     */
    private String sbjbjgDm;

    /**
     * 错误信息
     */
    private String errorMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
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

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getSbjbjgDm() {
        return sbjbjgDm;
    }

    public void setSbjbjgDm(String sbjbjgDm) {
        this.sbjbjgDm = sbjbjgDm;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
