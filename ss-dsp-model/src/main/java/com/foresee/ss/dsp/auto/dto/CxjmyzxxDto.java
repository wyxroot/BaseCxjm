package com.foresee.ss.dsp.auto.dto;

import java.io.Serializable;

/**
 * 描述:
 * TODO
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 16:41
 */
public class CxjmyzxxDto implements Serializable {

    /**
     *  序号
     */
    private String xh;

    /**
     * 应征明细序号
     */
    private String sbYzmxXh;

    /**
     * 个人编号
     */
    private String grbh;

    /**
     * 证件号码
     */
    private String zjhm;

    /**
     * 姓名
     */
    private String xm;

    /**
     * 险种类型
     */
    private String xzlxDm;

    /**
     * 应缴金额
     */
    private String yjje;

    /**
     * 费款所属期起
     */
    private String sfssqQsrq;

    /**
     * 费款所属期止
     */
    private String sfssqZzrq;

    /**
     * 缴款期限
     */
    private String jkQx;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getSbYzmxXh() {
        return sbYzmxXh;
    }

    public void setSbYzmxXh(String sbYzmxXh) {
        this.sbYzmxXh = sbYzmxXh;
    }

    public String getGrbh() {
        return grbh;
    }

    public void setGrbh(String grbh) {
        this.grbh = grbh;
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

    public String getXzlxDm() {
        return xzlxDm;
    }

    public void setXzlxDm(String xzlxDm) {
        this.xzlxDm = xzlxDm;
    }

    public String getYjje() {
        return yjje;
    }

    public void setYjje(String yjje) {
        this.yjje = yjje;
    }

    public String getSfssqQsrq() {
        return sfssqQsrq;
    }

    public void setSfssqQsrq(String sfssqQsrq) {
        this.sfssqQsrq = sfssqQsrq;
    }

    public String getSfssqZzrq() {
        return sfssqZzrq;
    }

    public void setSfssqZzrq(String sfssqZzrq) {
        this.sfssqZzrq = sfssqZzrq;
    }

    public String getJkQx() {
        return jkQx;
    }

    public void setJkQx(String jkQx) {
        this.jkQx = jkQx;
    }

    @Override
    public String toString() {
        return "CxjmyzxxDto{" +
                "xh='" + xh + '\'' +
                ", sbYzmxXh='" + sbYzmxXh + '\'' +
                ", grbh='" + grbh + '\'' +
                ", zjhm='" + zjhm + '\'' +
                ", xm='" + xm + '\'' +
                ", xzlxDm='" + xzlxDm + '\'' +
                ", yjje='" + yjje + '\'' +
                ", sfssqQsrq='" + sfssqQsrq + '\'' +
                ", sfssqZzrq='" + sfssqZzrq + '\'' +
                ", jkQx='" + jkQx + '\'' +
                '}';
    }
}
