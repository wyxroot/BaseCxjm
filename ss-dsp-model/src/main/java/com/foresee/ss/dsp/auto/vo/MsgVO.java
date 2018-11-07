package com.foresee.ss.dsp.auto.vo;

import java.io.Serializable;

/**
 * 描述:
 *  消息实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-01 14:15
 */
public class MsgVO implements Serializable {

    public  boolean flag;
    public  String msg;

    private MsgVO(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public static MsgVO success(String msg){
        return new MsgVO(true,msg);
    }

    public static MsgVO fail(String msg){
        return new MsgVO(false,msg);
    }
}
