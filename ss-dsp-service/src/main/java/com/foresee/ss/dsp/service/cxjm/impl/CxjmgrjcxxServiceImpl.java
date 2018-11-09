package com.foresee.ss.dsp.service.cxjm.impl;

import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.base.impl.BaseServiceImpl;
import com.foresee.ss.dsp.service.cxjm.CxjmgrjcxxService;
import com.foresee.ss.dsp.auto.base.dto.BaseDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrjcxx;
import com.foresee.icap.common.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述:
 * 城乡居民个人基础信息服务层实现类
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 11:29
 */
@Service
public class CxjmgrjcxxServiceImpl extends BaseServiceImpl<SfzjCxjmgrjcxx> implements CxjmgrjcxxService {


    @Override
    public String checkMyParam(SfzjCxjmgrjcxx param) {
        if (StrUtil.isBlank(param.getShbzh())) {
            return ErrorMsg.NOTNULL_SHBZH;
        }

        if (StrUtil.isBlank(param.getZjlx())) {
            return ErrorMsg.NOTNULL_ZJLX;
        }

        if (StrUtil.isBlank(param.getZjhm())) {
            return ErrorMsg.NOTNULL_ZJHM;
        }

        if (StrUtil.isBlank(param.getXm())) {
            return ErrorMsg.NOTNULL_XM;
        }

        if (StrUtil.isBlank(param.getXb())) {
            return ErrorMsg.NOTNULL_XB;
        }

        if (StrUtil.isBlank(param.getGjdqDm())) {
            return ErrorMsg.NOTNULL_GJDQ_DM;
        }

        if (StrUtil.isBlank(param.getHjlxDm())) {
            return ErrorMsg.NOTNULL_HJLX_DM;
        }

        //设置必要的参数
        //导入时间
        param.setDrSj(new Date());
        //读取结果类型
        param.setDqjglxDm("0");
        return null;
    }

    @Override
    public CxjmgrxxErrorMsg setErrorMsg(String result, SfzjCxjmgrjcxx model) {
        if (model == null) {
            return null;
        }

        CxjmgrxxErrorMsg errorMsg = new CxjmgrxxErrorMsg();
        errorMsg.setErrorMsg(result);
        errorMsg.setErrorCode(101);
        errorMsg.setXh(model.getXh());
        errorMsg.setGrbh(model.getGrbh());
        errorMsg.setZjhm(model.getZjhm());
        errorMsg.setXm(model.getXm());
        errorMsg.setFkxx(model);

        return errorMsg;
    }


}
