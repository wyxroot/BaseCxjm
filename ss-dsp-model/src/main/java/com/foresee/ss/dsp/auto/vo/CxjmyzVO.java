package com.foresee.ss.dsp.auto.vo;

import com.foresee.ss.dsp.auto.dto.CxjmyzxxDto;
import com.foresee.ss.dsp.auto.model.Dwjbxx;

import java.io.Serializable;

/**
 * 描述:
 * 城乡居民应征信息 VO
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 16:53
 */
public class CxjmyzVO implements Serializable {

    /**
     * 批次
     */
    private String cspch;

    /**
     *  单位经办信息
     */
    private Dwjbxx dwjbxx;

    /**
     * 个人应征信息
     */
    private CxjmyzxxDto insertGryzmxGrid;

    public String getCspch() {
        return cspch;
    }

    public void setCspch(String cspch) {
        this.cspch = cspch;
    }

    public Dwjbxx getDwjbxx() {
        return dwjbxx;
    }

    public void setDwjbxx(Dwjbxx dwjbxx) {
        this.dwjbxx = dwjbxx;
    }

    public CxjmyzxxDto getInsertGryzmxGrid() {
        return insertGryzmxGrid;
    }

    public void setInsertGryzmxGrid(CxjmyzxxDto insertGryzmxGrid) {
        this.insertGryzmxGrid = insertGryzmxGrid;
    }

    @Override
    public String toString() {
        return "CxjmyzVO{" +
                "cspch='" + cspch + '\'' +
                ", dwjbxx=" + dwjbxx +
                ", insertGryzmxGrid=" + insertGryzmxGrid +
                '}';
    }
}
