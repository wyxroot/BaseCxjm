package com.foresee.ss.dsp.service.cxjm.impl;

import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.base.impl.BaseServiceImpl;
import com.foresee.ss.dsp.service.cxjm.CxjmgrcbxxService;
import com.foresee.ss.dsp.auto.base.dto.BaseDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import com.foresee.icap.common.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述:
 * 城乡居民个人基础信息业务层实现
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-01 14:04
 */
@Service
public class CxjmgrcbxxServiceImpl extends BaseServiceImpl<SfzjCxjmgrcbxx, BaseDto> implements CxjmgrcbxxService {


    @Override
    public String checkMyParam(SfzjCxjmgrcbxx param) {

        if ( StrUtil.isBlank(param.getXzlxDm()) ){
            return ErrorMsg.NOTNULL_XZLX_DM;
        }

        if ( StrUtil.isBlank(param.getTcqbmDm()) ){
            return ErrorMsg.NOTNULL_TCQBM_DM;
        }

        if ( StrUtil.isBlank(param.getSbjbjgDm()) ){
            return ErrorMsg.NOTNULL_SBJBJG_DM;
        }

        if ( StrUtil.isBlank(param.getDwbh()) ){
            return ErrorMsg.NOTNULL_DWBH;
        }

        if ( StrUtil.isBlank(param.getDwbhSw()) ){
            return ErrorMsg.NOTNULL_DWBH_SW;
        }

        if ( StrUtil.isBlank(param.getXzjdDm()) ){
            return ErrorMsg.NOTNULL_XZJD_DM;
        }

        if ( StrUtil.isBlank(param.getSqcbhDm()) ){
            return ErrorMsg.NOTNULL_SQCBH_DM;
        }

        if ( StrUtil.isBlank(param.getRycbbglxDm())){
            return ErrorMsg.NOTNULL_RYCBBGLX_DM;
        }

        //设置必要的参数
        //导入时间
        param.setDrSj(new Date());
        //读取结果类型
        param.setDqjglxDm("0");
        //人员参保状态
        param.setRycbbglxDm("1");


        return  null;
    }

    @Override
    public CxjmgrxxErrorMsg setErrorMsg(String result, SfzjCxjmgrcbxx model) {
        if (model == null) {
            return  null;
        }

        CxjmgrxxErrorMsg errorMsg = new CxjmgrxxErrorMsg();
        errorMsg.setErrorMsg(result);
        errorMsg.setErrorCode(101);
        errorMsg.setXh(model.getXh());
        errorMsg.setGrbh(model.getGrbh());
        errorMsg.setZjhm(model.getSbjbjgDm());
        errorMsg.setXm(model.getDwbh());
        errorMsg.setFkxx(model);

        return errorMsg;
    }
}
