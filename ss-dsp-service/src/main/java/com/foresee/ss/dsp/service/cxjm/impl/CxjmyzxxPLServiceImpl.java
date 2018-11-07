package com.foresee.ss.dsp.service.cxjm.impl;

import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.cxjm.CxjmyzxxPLService;
import com.foresee.ss.dsp.auto.dao.SfzjCxjmyzxxMapper;
import com.foresee.ss.dsp.auto.dto.CbxxProcdure;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgeyzPLMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxx;
import com.foresee.ss.dsp.auto.vo.CxjmyzPLVO;
import com.foresee.icap.common.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *  两居应征批量交换业务层实现类
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-02 11:14
 */
@Service
public class CxjmyzxxPLServiceImpl implements CxjmyzxxPLService {

    @Autowired
    private SfzjCxjmyzxxMapper cxjmyzxxMapper;

    @Override
    @Transient
    public List<CxjmgeyzPLMsg> checkAndSave(CxjmyzPLVO<SfzjCxjmyzxx> cxjmyzPLVO) {

        List<CxjmgeyzPLMsg> errorList = new ArrayList<>();

        if ( StrUtil.isBlank(cxjmyzPLVO.getCspch()) ){
             setError(101, ErrorMsg.NOTNULL_CSPCH,null,null);
             return errorList;
        }

        List<SfzjCxjmyzxx> insertList = cxjmyzPLVO.getInsertGryzmxGrid();
        if(insertList == null || insertList.size() == 0 ){
            setError(101,ErrorMsg.NOTNULL_INS_DATA,null,null);
            return errorList;
        }

        List<CbxxProcdure> cbxxProList = new ArrayList<>();
        for (SfzjCxjmyzxx sfzjCxjmyzxx : insertList) {
            try {
                String msg = checkYzxxParam(sfzjCxjmyzxx);
                if (msg == null){
                    //效验通过, 保存数据
                    sfzjCxjmyzxx.setDrSj(new Date());
                    //cxjmyzxxMapper.insert(sfzjCxjmyzxx);

                    CbxxProcdure cbxxProcdure = new CbxxProcdure();
                    //保存数据并调用存储过程
                    cxjmyzxxMapper.insert(sfzjCxjmyzxx);
                    cxjmyzxxMapper.procedure(sfzjCxjmyzxx);
                    cbxxProcdure.setCode(sfzjCxjmyzxx.getCode());
                    cbxxProcdure.setMsg(sfzjCxjmyzxx.getMsg());
                    cbxxProList.add(cbxxProcdure);
                }else{
                    setError(101,msg,errorList,sfzjCxjmyzxx);
                }
            }catch (Exception e){
                e.printStackTrace();
                setError(199,ErrorMsg.UNKNOWN_ERROR,errorList,sfzjCxjmyzxx);
            }
        }
        printResult(cbxxProList);
        return errorList;

    }

    /**
     * print result
     * @param cbxxProList
     */
    private void printResult(List<CbxxProcdure> cbxxProList) {
        System.out.println("========================================================");
        for (CbxxProcdure cbxxProcdure : cbxxProList) {
            System.out.println("存储过程返回的数据: ");
            System.out.println(cbxxProcdure);
            System.out.println("-----");
        }


        System.out.println("========================================================");
    }



    private String checkYzxxParam(SfzjCxjmyzxx sfzjCxjmyzxx) {
        if (sfzjCxjmyzxx == null){
            return ErrorMsg.NOTNULL_DATA;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getXh())){
            return ErrorMsg.NOTNULL_XH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getSbYzXh()) ){
            return ErrorMsg.NOTNULL_SB_YZ_XH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getSbYzmxXh()) ){
            return ErrorMsg.NOTNULL_SB_YZMX_XH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getSbjbjgDm())){
            return ErrorMsg.NOTNULL_SBJBJG_DM;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getDwbh())){
            return ErrorMsg.NOTNULL_DWBH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getGrbh())){
            return ErrorMsg.NOTNULL_GRBH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getXzlxDm())){
            return ErrorMsg.NOTNULL_XZLX_DM;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getYjje())){
            return ErrorMsg.NOTNULL_YJJE;
        }

        if ( sfzjCxjmyzxx.getSfssqQsrq() == null){
            return ErrorMsg.NOTNULL_SFSSQ_QSRQ;
        }

        if ( sfzjCxjmyzxx.getSfssqZzrq() == null){
            return ErrorMsg.NOTNULL_SFSSQ_ZZRQ;
        }

        if ( sfzjCxjmyzxx.getJkQx() == null){
            return ErrorMsg.NOTNULL_JKQX;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getYhhbDm())){
            return ErrorMsg.NOTNULL_YHHB_DM;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getYhZhkhm())){
            return ErrorMsg.NOTNULL_YH_ZHKHM;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getYhZh())){
            return ErrorMsg.NOTNULL_YHZH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getZhbh())){
            return ErrorMsg.NOTNULL_ZHBH;
        }

        if ( StrUtil.isBlank(sfzjCxjmyzxx.getSjlylx())){
            return ErrorMsg.NOTNULL_SJLYLX;
        }

        return null;
    }



    private void setError(int errCode, String msg, List<CxjmgeyzPLMsg> errorList, SfzjCxjmyzxx errorData) {
        CxjmgeyzPLMsg<SfzjCxjmyzxx> cxjmgeyzPLMsg = new CxjmgeyzPLMsg();
        cxjmgeyzPLMsg.setReturnCode(errCode);
        cxjmgeyzPLMsg.setReturnMsg(msg);
        cxjmgeyzPLMsg.setFkxx(errorData);

        errorList.add(cxjmgeyzPLMsg);
    }

}
