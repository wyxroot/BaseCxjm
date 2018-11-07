package com.foresee.ss.dsp.auto.vo;

import com.foresee.ss.dsp.auto.model.Gryzmx;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 两居应征批量交换VO
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-02 10:33
 */
public class CxjmyzPLVO<T> implements Serializable {

    /**
     * 传输批次号
     */
    private String cspch;

    /**
     * 记录数与生成日期
     */
    private Gryzmx gryzmx;

    /**
     * 两居应征实体
     */
    private List<T> insertGryzmxGrid;

    public String getCspch() {
        return cspch;
    }

    public void setCspch(String cspch) {
        this.cspch = cspch;
    }

    public Gryzmx getGryzmx() {
        return gryzmx;
    }

    public void setGryzmx(Gryzmx gryzmx) {
        this.gryzmx = gryzmx;
    }

    public List<T> getInsertGryzmxGrid() {
        return insertGryzmxGrid;
    }

    public void setInsertGryzmxGrid(List<T> insertGryzmxGrid) {
        this.insertGryzmxGrid = insertGryzmxGrid;
    }
}
