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
public interface BaseService<T extends BaseModel,Dto extends BaseDto> {

    /**
     * 效验参数
     * @param param
     * @return
     */
    String checkInsParam(T  param);

    /**
     * 保存数据
     * @param paramList  errorResult
     * @return
     */
    List<CxjmgrxxErrorMsg> checkAndSave(List<T> paramList);

    /**
     * 更新并效验数据
     * @param dto  errorResult
     * @return
     */
    List<CxjmgrxxErrorMsg> checkAndUpdate(List<Dto> dto);


}
