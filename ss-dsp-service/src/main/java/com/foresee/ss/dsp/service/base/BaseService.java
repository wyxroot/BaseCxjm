package com.foresee.ss.dsp.service.base;

import com.foresee.ss.dsp.auto.base.dto.BaseDto;
import com.foresee.ss.dsp.auto.base.model.BaseModel;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;

import java.util.List;

/**
 * 描述:
 *  抽取公共代码接口
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 14:14
 */
public interface BaseService<T> {

    /**
     * 效验参数
     * @param param
     * @return
     */
    String checkParam(T  param);

    /**
     * 保存数据
     * @param insertList  errorResult
     * @return
     */
    List<CxjmgrxxErrorMsg> checkAndSave(List<T> insertList);

    /**
     * 更新并效验数据
     * @param updateList  errorResult
     * @return
     */
    List<CxjmgrxxErrorMsg> checkAndUpdate(List<T> updateList);


}
