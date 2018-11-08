package com.foresee.ss.dsp.auto.model;

import java.io.Serializable;

/**
 * 描述:
 * 单位基本信息模型
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 16:25
 */
public class Dwjbxx implements Serializable {

    /**
     * 社保经办机构
     */
    private String sbjbDm;

    /**
     * 单位编号
     */
    private String dwbh;

    /**
     * 单位编号 (税务)
     */
    private String dwbhSw;

    /**
     * 应征序号
     */
    private String sbYzXh;

    /**
     * 缴费银行行别
     */
    private String yhhbDm;

    /**
     * 缴费账号开户名
     */
    private String yhZhkhm;

    /**
     * 缴费账号
     */
    private String yhZh;

    /**
     * 支行编码
     */
    private String zhbm;

    /**
     * 签约协议书号
     */
    private String qyxysh;

    /**
     * 签约要素
     */
    private String qyys;

    /**
     * 记录数
     */
    private String jls;

    /**
     * 生成日期
     */
    private String scRq;

    /**
     * 数据来源类型
     */
    private String sjlylx;


    public String getYhZhkhm() {
        return yhZhkhm;
    }

    public void setYhZhkhm(String yhZhkhm) {
        this.yhZhkhm = yhZhkhm;
    }

    public String getSbjbDm() {
        return sbjbDm;
    }

    public void setSbjbDm(String sbjbDm) {
        this.sbjbDm = sbjbDm;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getDwbhSw() {
        return dwbhSw;
    }

    public void setDwbhSw(String dwbhSw) {
        this.dwbhSw = dwbhSw;
    }

    public String getSbYzXh() {
        return sbYzXh;
    }

    public void setSbYzXh(String sbYzXh) {
        this.sbYzXh = sbYzXh;
    }

    public String getYhhbDm() {
        return yhhbDm;
    }

    public void setYhhbDm(String yhhbDm) {
        this.yhhbDm = yhhbDm;
    }



    public String getYhZh() {
        return yhZh;
    }

    public void setYhZh(String yhZh) {
        this.yhZh = yhZh;
    }

    public String getZhbm() {
        return zhbm;
    }

    public void setZhbm(String zhbm) {
        this.zhbm = zhbm;
    }

    public String getQyxysh() {
        return qyxysh;
    }

    public void setQyxysh(String qyxysh) {
        this.qyxysh = qyxysh;
    }

    public String getQyys() {
        return qyys;
    }

    public void setQyys(String qyys) {
        this.qyys = qyys;
    }

    public String getJls() {
        return jls;
    }

    public void setJls(String jls) {
        this.jls = jls;
    }

    public String getScRq() {
        return scRq;
    }

    public void setScRq(String scRq) {
        this.scRq = scRq;
    }

    public String getSjlylx() {
        return sjlylx;
    }

    public void setSjlylx(String sjlylx) {
        this.sjlylx = sjlylx;
    }

    @Override
    public String toString() {
        return "Dwjbxx{" +
                "sbjbDm='" + sbjbDm + '\'' +
                ", dwbh='" + dwbh + '\'' +
                ", dwbhSw='" + dwbhSw + '\'' +
                ", sbYzXh='" + sbYzXh + '\'' +
                ", yhhbDm='" + yhhbDm + '\'' +
                ", yhZhkhm='" + yhZhkhm + '\'' +
                ", yhZh='" + yhZh + '\'' +
                ", zhbm='" + zhbm + '\'' +
                ", qyxysh='" + qyxysh + '\'' +
                ", qyys='" + qyys + '\'' +
                ", jls='" + jls + '\'' +
                ", scRq='" + scRq + '\'' +
                ", sjlylx='" + sjlylx + '\'' +
                '}';
    }
}
