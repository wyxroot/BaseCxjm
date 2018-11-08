package com.foresee.ss.dsp.rest;

import com.foresee.ss.dsp.auto.base.dto.BaseDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import com.foresee.ss.dsp.service.base.impl.BaseServiceImpl;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 描述:
 *
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 15:40
 */
public class RefDemo extends BaseServiceImpl<SfzjCxjmgrcbxx> {

    @Override
    public String checkMyParam(SfzjCxjmgrcbxx param) {
        return null;
    }

    @Override
    public CxjmgrxxErrorMsg setErrorMsg(String result, SfzjCxjmgrcbxx model) {
        return null;
    }

    @Test
    public void Test()throws Exception{
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Object o = Class.forName(actualTypeArguments[0].getTypeName()).newInstance();
        System.out.println(o);


    }
}
