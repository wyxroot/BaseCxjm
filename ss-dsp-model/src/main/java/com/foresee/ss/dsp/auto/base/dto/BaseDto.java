package com.foresee.ss.dsp.auto.base.dto;

import java.io.Serializable;

/**
 * 描述:
 * 城乡居民个人基础信息数据更新交互实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 11:20
 */
public class BaseDto implements Serializable {

    /**
     * 序号
     */
    private String xh;

    /**
     * 个人编号
     */
    private String grbh;

    /**
     * 所属行政区
     */
    private String xzqhxqDm;

    /**
     * 数据来源类型
     */
    private String sjlylx;

    /**
     * 个人编号(税务)
     */
    private String grbhSw;

    /**
     * 变更项目名称
     */
    private String bgxmMc;

    /**
     * 变更前内容
     */
    private String bgqz;

    /**
     * 变更后内容
     */
    private String bghz;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getGrbh() {
        return grbh;
    }

    public void setGrbh(String grbh) {
        this.grbh = grbh;
    }

    public String getXzqhxqDm() {
        return xzqhxqDm;
    }

    public void setXzqhxqDm(String xzqhxqDm) {
        this.xzqhxqDm = xzqhxqDm;
    }

    public String getSjlylx() {
        return sjlylx;
    }

    public void setSjlylx(String sjlylx) {
        this.sjlylx = sjlylx;
    }

    public String getGrbhSw() {
        return grbhSw;
    }

    public void setGrbhSw(String grbhSw) {
        this.grbhSw = grbhSw;
    }

    public String getBgxmMc() {
        return bgxmMc;
    }

    public void setBgxmMc(String bgxmMc) {
        this.bgxmMc = bgxmMc;
    }

    public String getBgqz() {
        return bgqz;
    }

    public void setBgqz(String bgqz) {
        this.bgqz = bgqz;
    }

    public String getBghz() {
        return bghz;
    }

    public void setBghz(String bghz) {
        this.bghz = bghz;
    }


}
