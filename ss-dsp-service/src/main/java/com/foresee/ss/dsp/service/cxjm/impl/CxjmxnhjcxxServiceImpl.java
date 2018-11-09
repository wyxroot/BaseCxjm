package com.foresee.ss.dsp.service.cxjm.impl;

import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.cxjm.CxjmxnhjcxxService;
import com.foresee.ss.dsp.auto.dao.SfzjCxjmxnhjcxxMapper;
import com.foresee.ss.dsp.auto.dto.msg.CxjmxnhjErrorMsg;
import com.foresee.ss.dsp.auto.dto.CxjmxnhjccDto;
import com.foresee.ss.dsp.auto.model.SfzjCxjmxnhjcxx;
import com.foresee.ss.dsp.auto.vo.ResultVO;
import com.foresee.icap.common.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 城乡居民虚拟户信息交换服务层实现
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 19:24
 */
@Service
public class CxjmxnhjcxxServiceImpl implements CxjmxnhjcxxService {

    private static final Logger logger = LoggerFactory.getLogger(CxjmxnhjcxxServiceImpl.class);

    @Autowired
    private SfzjCxjmxnhjcxxMapper cxjmxnhjcxxMapper;

    @Override
    public List<CxjmxnhjErrorMsg> checkAndSave(List<SfzjCxjmxnhjcxx> insertDwjbxxGrid, ResultVO resultVO) {
        List<CxjmxnhjErrorMsg> insertErrList = new ArrayList<>();
        for (SfzjCxjmxnhjcxx sfzjCxjmxnhjcxx : insertDwjbxxGrid) {

            String msg = checkData(sfzjCxjmxnhjcxx);
            try {
                if (msg == null) {
                    //效验通过
                    sfzjCxjmxnhjcxx.setDrSj(new Date());
                    cxjmxnhjcxxMapper.insert(sfzjCxjmxnhjcxx);
                } else {
                    setError("199", msg, insertErrList, sfzjCxjmxnhjcxx);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                setError("199", "未知错误", insertErrList, sfzjCxjmxnhjcxx);
            }

        }
        return insertErrList;
    }


    @Override
    public List<CxjmxnhjErrorMsg> checkAndUpdate(List<SfzjCxjmxnhjcxx> updateDwjbxxGrid, ResultVO resultVO) {
        List<CxjmxnhjErrorMsg> updateErrList = new ArrayList<>();
        for (SfzjCxjmxnhjcxx cxjmxnhjcc : updateDwjbxxGrid) {

            String msg = checkData(cxjmxnhjcc);
            int i;
            try {
                if (msg == null) {
                    //效验通过
                    i = cxjmxnhjcxxMapper.updateByPrimaryKeySelective(cxjmxnhjcc);
                    if (i == 0) {
                        setError("199", "找不到要更新数据的 xh !!!", updateErrList, cxjmxnhjcc);
                    }
                } else {
                    setError("199", msg, updateErrList, cxjmxnhjcc);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                setError("199", "未知错误", updateErrList, cxjmxnhjcc);
            }

        }
        return updateErrList;
    }


    @Override
    public List<CxjmxnhjErrorMsg> checkAndDelete(List<SfzjCxjmxnhjcxx> deleteDwjbxxGrid, ResultVO resultVO) {
        List<CxjmxnhjErrorMsg> deleteErrList = new ArrayList<>();

        for (SfzjCxjmxnhjcxx deletejcxx : deleteDwjbxxGrid) {
            String msg = checkDeleteData(deletejcxx);
            int i = 0;

            try {
                if (msg == null) {
                    //效验通过
                    i = cxjmxnhjcxxMapper.deleteByPrimaryKey(deletejcxx.getXh());
                } else {
                    setError("101", msg, deleteErrList, deletejcxx);
                }

                if (i == 0) {
                    setError("101", ErrorMsg.NOTFIND_DELETE_DATA, deleteErrList, deletejcxx);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                setError("199", ErrorMsg.UNKNOWN_ERROR, deleteErrList, deletejcxx);
            }

        }
        return deleteErrList;
    }


//    private String checkUpdateData(CxjmxnhjccDto cxjmxnhjccDto) {
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getXh())){
//            return ErrorMsg.NOTNULL_XH;
//        }
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getDwbh())){
//            return ErrorMsg.NOTNULL_DWBH;
//        }
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getDwbhSw())){
//            return ErrorMsg.NOTNULL_DWBH_SW;
//        }
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getDwmc())){
//            return ErrorMsg.NOTNULL_DWMC;
//        }
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getBgxmMc())){
//            return ErrorMsg.NOTNULL_BGXM_MC;
//        }
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getBgqz())){
//            return ErrorMsg.NOTNULL_BGQZ;
//        }
//
//        if ( StrUtil.isBlank(cxjmxnhjccDto.getBghz())){
//            return ErrorMsg.NOTNULL_BGHZ;
//        }
//
//        return null;
//    }

    private String checkData(SfzjCxjmxnhjcxx sfzjCxjmxnhjcxx) {

        checkDeleteData(sfzjCxjmxnhjcxx);

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getDwmc())) {
            return ErrorMsg.NOTNULL_DWMC;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getShxydm())) {
            return ErrorMsg.NOTNULL_SHXYDM;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getZzjgDm())) {
            return ErrorMsg.NOTNULL_ZZJG_DM;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getSbjbjgDm())) {
            return ErrorMsg.NOTNULL_SBJBJG_DM;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getSbtcjcDm())) {
            return ErrorMsg.NOTNULL_SBTCJC_DM;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getXzqhxqDm())) {
            return ErrorMsg.NOTNULL_XZQHXQ_DM;
        }

        return null;
    }

    private String checkDeleteData(SfzjCxjmxnhjcxx sfzjCxjmxnhjcxx) {

        if (sfzjCxjmxnhjcxx == null) {
            return "数据为空";
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getXh())) {
            return ErrorMsg.NOTNULL_XH;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getDwbh())) {
            return ErrorMsg.NOTNULL_DWBH;
        }

        if (StrUtil.isBlank(sfzjCxjmxnhjcxx.getDwbhSw())) {
            return ErrorMsg.NOTNULL_DWBH_SW;
        }

        return null;
    }


    private void setError(String errCode, String msg, List<CxjmxnhjErrorMsg> errorList, SfzjCxjmxnhjcxx sfzjCxjmxnhjcxx) {
        CxjmxnhjErrorMsg<SfzjCxjmxnhjcxx> errMsg = new CxjmxnhjErrorMsg();
        errMsg.setErrorCode(errCode);
        errMsg.setErrorMsg(msg);

        if (sfzjCxjmxnhjcxx != null) {
            errMsg.setXh(sfzjCxjmxnhjcxx.getXh());
            errMsg.setDwbh(sfzjCxjmxnhjcxx.getDwbh());
            errMsg.setDwmc(sfzjCxjmxnhjcxx.getDwmc());
            errMsg.setSbjbjgDm(sfzjCxjmxnhjcxx.getSbjbjgDm());
        }

        errMsg.setFkxx(sfzjCxjmxnhjcxx);
        errorList.add(errMsg);
    }
}
