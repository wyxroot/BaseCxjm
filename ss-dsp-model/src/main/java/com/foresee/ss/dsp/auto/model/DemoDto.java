package com.foresee.ss.dsp.auto.model;

import java.io.Serializable;
import java.util.Date;

public class DemoDto implements Serializable {
    /**
     * 表 : T_DEMO_TEST
     * 对应字段 : ID
     */
    private Long id;

    /**
     * 表 : T_DEMO_TEST
     * 对应字段 : MESSAGE
     */
    private String message;

    /**
     * 表 : T_DEMO_TEST
     * 对应字段 : CREATE_TIME
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEMO_TEST
     *
     * @MBG Generated Wed Oct 31 10:40:31 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return T_DEMO_TEST.ID：null
     */
    public Long getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  null
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return T_DEMO_TEST.MESSAGE：null
     */
    public String getMessage() {
        return message;
    }

    /**
     * set method 
     *
     * @param message  null
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * get method 
     *
     * @return T_DEMO_TEST.CREATE_TIME：null
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * set method 
     *
     * @param createTime  null
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", message=").append(message);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}