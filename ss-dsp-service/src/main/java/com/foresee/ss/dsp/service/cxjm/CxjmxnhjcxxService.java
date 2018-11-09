package com.foresee.ss.dsp.service.cxjm;

import com.foresee.ss.dsp.auto.dto.msg.CxjmxnhjErrorMsg;
import com.foresee.ss.dsp.auto.dto.CxjmxnhjccDto;
import com.foresee.ss.dsp.auto.model.SfzjCxjmxnhjcxx;
import com.foresee.ss.dsp.auto.vo.ResultVO;

import java.util.List;

/**
 * 描述:
 * 城乡居民虚拟户信息交换服务层接口
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 19:23
 */
public interface CxjmxnhjcxxService {

    /**
     * 效验并保存数据, resultVO 用于封装错误数据的结果集
     *
     * @param insertDwjbxxGrid
     * @param resultVO
     */
    List<CxjmxnhjErrorMsg> checkAndSave(List<SfzjCxjmxnhjcxx> insertDwjbxxGrid, ResultVO resultVO);


    /**
     * 效验并更新数据, resultVO 用于封装错误数据的结果集
     *
     * @param updateDwjbxxGrid
     * @param resultVO
     */
    List<CxjmxnhjErrorMsg> checkAndUpdate(List<SfzjCxjmxnhjcxx> updateDwjbxxGrid, ResultVO resultVO);

    /**
     * 效验并删除数据, resultVO 用于封装错误数据的结果集
     *
     * @param deleteDwjbxxGrid
     * @param resultVO
     */
    List<CxjmxnhjErrorMsg> checkAndDelete(List<SfzjCxjmxnhjcxx> deleteDwjbxxGrid, ResultVO resultVO);
}
