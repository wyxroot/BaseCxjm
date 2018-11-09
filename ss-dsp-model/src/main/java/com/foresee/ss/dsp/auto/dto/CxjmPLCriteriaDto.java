package com.foresee.ss.dsp.auto.dto;

/**
 * 描述:
 * 两居批量应征查询条件数据交互实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-09 15:39
 */
public class CxjmPLCriteriaDto {

    /**
     * 社保参保疾患编码
     */
    private String sbjbjgDm;

    /**
     * 应征序号
     */
    private String sbYzXh;

    /**
     * 单位编号
     */
    private String dwbh;

    /**
     * 传输批次号
     */
    private String cspch;

    public String getSbjbjgDm() {
        return sbjbjgDm;
    }

    public void setSbjbjgDm(String sbjbjgDm) {
        this.sbjbjgDm = sbjbjgDm;
    }

    public String getSbYzXh() {
        return sbYzXh;
    }

    public void setSbYzXh(String sbYzXh) {
        this.sbYzXh = sbYzXh;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getCspch() {
        return cspch;
    }

    public void setCspch(String cspch) {
        this.cspch = cspch;
    }
}
