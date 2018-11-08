package com.foresee.ss.dsp.auto.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 封装 insert and update 的数据
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-01 16:07
 */
public class CxjmxxVO<T> implements Serializable {

    private String cspch;

    private List<T> insertGrjbxxGrid;

    private List<T> updateGrjbxxGrid;


    public List<T> getInsertGrjbxxGrid() {
        return insertGrjbxxGrid;
    }

    public void setInsertGrjbxxGrid(List<T> insertGrjbxxGrid) {
        this.insertGrjbxxGrid = insertGrjbxxGrid;
    }

    public List<T> getUpdateGrjbxxGrid() {
        return updateGrjbxxGrid;
    }

    public void setUpdateGrjbxxGrid(List<T> updateGrjbxxGrid) {
        this.updateGrjbxxGrid = updateGrjbxxGrid;
    }

    public String getCspch() {
        return cspch;
    }

    public void setCspch(String cspch) {
        this.cspch = cspch;
    }

}
