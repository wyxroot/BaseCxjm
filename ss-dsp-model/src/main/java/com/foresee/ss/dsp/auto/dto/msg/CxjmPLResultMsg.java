package com.foresee.ss.dsp.auto.dto.msg;

/**
 * 描述:
 * 城乡居民批量结果实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-09 15:54
 */
public class CxjmPLResultMsg {

    /**
     * 序号
     */
    private String xh;

    /**
     * 社保管理机关代码
     */
    private String sbjbjgDm;

    /**
     * 单位编号
     */
    private String dwbh;

    /**
     * 应征序号
     */
    private String sbYzXh;

    /**
     * 应征明细序号
     */
    private String sbYzmxXh;

    /**
     * 险种类型
     */
    private String xzlxDm;

    /**
     * 读取结果类型
     */
    private String dqjglxDm;

    /**
     * 错误信息
     */
    private String errorMsg;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getSbjbjgDm() {
        return sbjbjgDm;
    }

    public void setSbjbjgDm(String sbjbjgDm) {
        this.sbjbjgDm = sbjbjgDm;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getSbYzXh() {
        return sbYzXh;
    }

    public void setSbYzXh(String sbYzXh) {
        this.sbYzXh = sbYzXh;
    }

    public String getSbYzmxXh() {
        return sbYzmxXh;
    }

    public void setSbYzmxXh(String sbYzmxXh) {
        this.sbYzmxXh = sbYzmxXh;
    }

    public String getXzlxDm() {
        return xzlxDm;
    }

    public void setXzlxDm(String xzlxDm) {
        this.xzlxDm = xzlxDm;
    }

    public String getDqjglxDm() {
        return dqjglxDm;
    }

    public void setDqjglxDm(String dqjglxDm) {
        this.dqjglxDm = dqjglxDm;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "CxjmPLResultMsg{" +
                "xh='" + xh + '\'' +
                ", sbjbjgDm='" + sbjbjgDm + '\'' +
                ", dwbh='" + dwbh + '\'' +
                ", sbYzXh='" + sbYzXh + '\'' +
                ", sbYzmxXh='" + sbYzmxXh + '\'' +
                ", xzlxDm='" + xzlxDm + '\'' +
                ", dqjglxDm='" + dqjglxDm + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
