package com.foresee.ss.dsp.service.cxjm.impl;

import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.cxjm.CxjmyzxxService;
import com.foresee.ss.dsp.auto.dto.CxjmyzxxDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgeyzMsg;
import com.foresee.ss.dsp.auto.model.Dwjbxx;
import com.foresee.ss.dsp.auto.vo.CxjmyzVO;
import com.foresee.icap.common.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *  个人应征数据交换业务层实现类
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 16:22
 */
@Service
public class CxjmyzxxServiceImpl implements CxjmyzxxService {



    @Override
    public List<CxjmgeyzMsg> checkAndSave(List<CxjmyzVO> cxjmyzVO) {
        List<CxjmgeyzMsg> errorList = new ArrayList<>();

        for (CxjmyzVO vo : cxjmyzVO) {
               if (vo == null){
                   return null;
               }

               if (vo.getDwjbxx() == null){
                   setError("101", ErrorMsg.NOTNULL_DWJBXX,vo,errorList);
               }

               if (vo.getInsertGryzmxGrid() == null){
                   setError("101",ErrorMsg.NOTNULL_INS_DATA,vo,errorList);
               }

               String msg = checkDwjbxx(vo.getDwjbxx());
               if (msg == null){
                    msg = checkInsert(vo.getInsertGryzmxGrid());

                    if (msg == null) {
                        //insert
                        System.out.println(vo);
                        continue;
                    }

                    setError("101",msg,vo,errorList);
                    continue;
               }
               setError("101",msg,vo,errorList);
        }

        return errorList;
    }


    private void setError(String errorCode, String msg, CxjmyzVO vo, List<CxjmgeyzMsg> errorList) {
        CxjmgeyzMsg  cxjmgeyzMsg = new CxjmgeyzMsg();
        cxjmgeyzMsg.setErrorCode(errorCode);
        cxjmgeyzMsg.setErrorMsg(msg);

        if (vo != null && vo.getInsertGryzmxGrid() != null){
            cxjmgeyzMsg.setXh(vo.getInsertGryzmxGrid().getXh());
            cxjmgeyzMsg.setGrbh(vo.getInsertGryzmxGrid().getGrbh());

            cxjmgeyzMsg.setDwbh(vo.getDwjbxx().getDwbh());
            cxjmgeyzMsg.setSbjbjg_dm(vo.getDwjbxx().getSbjbDm());

            cxjmgeyzMsg.setSfssqQrq(vo.getInsertGryzmxGrid().getSfssqQsrq());
            cxjmgeyzMsg.setSfssqZzrq(vo.getInsertGryzmxGrid().getSfssqZzrq());

            cxjmgeyzMsg.setXzlxDm(vo.getInsertGryzmxGrid().getXzlxDm());
            cxjmgeyzMsg.setYjje(vo.getInsertGryzmxGrid().getYjje());
        }

        errorList.add(cxjmgeyzMsg);
    }



    private String checkInsert(CxjmyzxxDto insertGryzmxGrid) {

        if ( StrUtil.isBlank(insertGryzmxGrid.getXh())){
            return ErrorMsg.NOTNULL_XH;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getSbYzmxXh())){
            return ErrorMsg.NOTNULL_SB_YZMX_XH;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getGrbh())){
            return ErrorMsg.NOTNULL_GRBH;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getZjhm())){
            return ErrorMsg.NOTNULL_ZJHM;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getYjje())){
            return ErrorMsg.NOTNULL_YJJE;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getSfssqQsrq())){
            return ErrorMsg.NOTNULL_SFSSQ_QSRQ;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getSfssqZzrq())){
            return ErrorMsg.NOTNULL_SFSSQ_ZZRQ;
        }

        if ( StrUtil.isBlank(insertGryzmxGrid.getJkQx())){
            return ErrorMsg.NOTNULL_JKQX;
        }

        return null;

    }






    private String checkDwjbxx(Dwjbxx dwjbxx) {

        if ( StrUtil.isBlank(dwjbxx.getSbjbDm())){
            return ErrorMsg.NOTNULL_SBJBJG_DM;
        }

        if ( StrUtil.isBlank(dwjbxx.getDwbh())){
            return ErrorMsg.NOTNULL_DWBH;
        }

        if ( StrUtil.isBlank(dwjbxx.getDwbhSw())){
            return ErrorMsg.NOTNULL_DWBH_SW;
        }

        if ( StrUtil.isBlank(dwjbxx.getQyys())){
            return ErrorMsg.NOTNULL_QYYS;
        }

        if ( StrUtil.isBlank(dwjbxx.getJls())){
            return ErrorMsg.NOTNULL_JLS;
        }

        if ( StrUtil.isBlank(dwjbxx.getScRq())){
            return ErrorMsg.NOTNULL_SC_RQ;
        }

        if ( StrUtil.isBlank(dwjbxx.getSjlylx())){
            return ErrorMsg.NOTNULL_SJLYLX;
        }

        return null;
    }





}
