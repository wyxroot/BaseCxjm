package com.foresee.ss.dsp.auto.dto;

import java.io.Serializable;

/**
 * 描述:
 * 参保信息存储过程返回数据交互实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 9:11
 */
public class CbxxProcdure implements Serializable {

    /**
     * 状态码
     */
    private String code;

    /**
     * 信息
     */
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CbxxProcdure{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
