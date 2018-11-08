package com.foresee.ss.dsp.auto.vo;

import com.foresee.ss.dsp.auto.dto.CxjmxnhjccDto;
import com.foresee.ss.dsp.auto.model.SfzjCxjmxnhjcxx;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *  城乡居民虚拟单位信息交换 VO
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 19:17
 */
public class CxjmxndwVO implements Serializable {

    /**
     * 传输批次号
     */
    private String cspch;

    /**
     * deleteDwjbxxGrid
     */
    private List<SfzjCxjmxnhjcxx> deleteDwjbxxGrid;

    /**
     * insertDwjbxxGrid
     */
    private List<SfzjCxjmxnhjcxx> insertDwjbxxGrid;

    /**
     * updateDwjbxxGrid
     */
    private List<SfzjCxjmxnhjcxx> updateDwjbxxGrid;



    public String getCspch() {
        return cspch;
    }

    public void setCspch(String cspch) {
        this.cspch = cspch;
    }

    public List<SfzjCxjmxnhjcxx> getInsertDwjbxxGrid() {
        return insertDwjbxxGrid;
    }

    public void setInsertDwjbxxGrid(List<SfzjCxjmxnhjcxx> insertDwjbxxGrid) {
        this.insertDwjbxxGrid = insertDwjbxxGrid;
    }

    public List<SfzjCxjmxnhjcxx> getDeleteDwjbxxGrid() {
        return deleteDwjbxxGrid;
    }

    public void setDeleteDwjbxxGrid(List<SfzjCxjmxnhjcxx> deleteDwjbxxGrid) {
        this.deleteDwjbxxGrid = deleteDwjbxxGrid;
    }

    public List<SfzjCxjmxnhjcxx> getUpdateDwjbxxGrid() {
        return updateDwjbxxGrid;
    }

    public void setUpdateDwjbxxGrid(List<SfzjCxjmxnhjcxx> updateDwjbxxGrid) {
        this.updateDwjbxxGrid = updateDwjbxxGrid;
    }
}
