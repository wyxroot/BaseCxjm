package com.foresee.ss.dsp.auto.dto;

import java.io.Serializable;

/**
 * 描述:
 * 城乡居民虚拟户信息更新实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 20:55
 */
public class CxjmxnhjccDto implements Serializable {

    /**
     * 序号
     */
    private String xh;

    /**
     * 单位编号(税务)
     */
    private String dwbhSw;

    /**
     * 单位编号
     */
    private String dwbh;

    /**
     * 单位名称
     */
    private String dwmc;

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

    public String getDwbhSw() {
        return dwbhSw;
    }

    public void setDwbhSw(String dwbhSw) {
        this.dwbhSw = dwbhSw;
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
