package com.foresee.ss.dsp.auto.dto.msg;


/**
 * 描述:
 *  城乡居民个人应征返回消息实体
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 17:01
 */
public class CxjmgeyzMsg{

    /**
     * 接口返回码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     *  序号
     */
    private String xh;

    /**
     * 个人编号
     */
    private String grbh;

    /**
     * 单位编号
     */
    private String dwbh;

    /**
     * 社保经办机构
     */
    private String sbjbjg_dm;

    /**
     *  费款所属期起
     */
    private String sfssqQrq;

    /**
     *  费款所属期止
     */
    private String sfssqZzrq;

    /**
     * 险种类型
     */
    private String xzlxDm;

    /**
     * 应缴金额
     */
    private String yjje;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getGrbh() {
        return grbh;
    }

    public void setGrbh(String grbh) {
        this.grbh = grbh;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getSbjbjg_dm() {
        return sbjbjg_dm;
    }

    public void setSbjbjg_dm(String sbjbjg_dm) {
        this.sbjbjg_dm = sbjbjg_dm;
    }

    public String getSfssqQrq() {
        return sfssqQrq;
    }

    public void setSfssqQrq(String sfssqQrq) {
        this.sfssqQrq = sfssqQrq;
    }

    public String getSfssqZzrq() {
        return sfssqZzrq;
    }

    public void setSfssqZzrq(String sfssqZzrq) {
        this.sfssqZzrq = sfssqZzrq;
    }

    public String getXzlxDm() {
        return xzlxDm;
    }

    public void setXzlxDm(String xzlxDm) {
        this.xzlxDm = xzlxDm;
    }

    public String getYjje() {
        return yjje;
    }

    public void setYjje(String yjje) {
        this.yjje = yjje;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
