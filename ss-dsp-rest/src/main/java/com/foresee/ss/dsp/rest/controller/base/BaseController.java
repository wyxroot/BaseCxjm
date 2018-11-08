package com.foresee.ss.dsp.rest.controller.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.base.model.BaseModel;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;
import com.foresee.ss.dsp.auto.vo.CxjmxxVO;
import com.foresee.ss.dsp.auto.vo.ResultVO;
import com.foresee.ss.dsp.service.base.BaseService;

/**
 * 描述:
 *  公用代码
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 16:17
 */
public class BaseController<T extends BaseModel> {

    @Autowired
    private BaseService<T> baseService;


    public Response saveOrUpdate(CxjmxxVO<T> cxjmgrcbxxVO){
        ResultVO errorResult = new ResultVO();

        /**
         * check and save
         */
        List<T> insList = cxjmgrcbxxVO.getInsertGrjbxxGrid();
        if(insList != null && insList.size() != 0){
            List<CxjmgrxxErrorMsg> insertErrList = baseService.checkAndSave(insList);
            errorResult.setInsertMsg(insertErrList);
        }


        /**
         * check and update
         */
        List<T> dtoList = cxjmgrcbxxVO.getUpdateGrjbxxGrid();
        if (dtoList != null && dtoList.size() != 0){
            List<CxjmgrxxErrorMsg> updateErrList = baseService.checkAndUpdate(dtoList);
            errorResult.setUpdateMsg(updateErrList);
        }


        return Response.success(null,errorResult);
    }
}
