package com.foresee.ss.dsp.rest.controller.cxjm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.dto.CxjmxnhjccDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmxnhjErrorMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmxnhjcxx;
import com.foresee.ss.dsp.auto.vo.CxjmxndwVO;
import com.foresee.ss.dsp.auto.vo.ResultVO;
import com.foresee.ss.dsp.service.cxjm.CxjmxnhjcxxService;

/**
 * 描述:
 * 两居虚拟户单位信息交换
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 19:10
 */
@RestController
@RequestMapping("/v1/unitInfo/")
public class CxjmxnhjcxxController {

    @Autowired
    private CxjmxnhjcxxService cxjmxnhjcxxService;

    @PostMapping("/saveOrUpdate")
    public Response saveOrUpdate(@RequestBody CxjmxndwVO cxjmxndwVO){
        if (cxjmxndwVO == null){
            return  Response.success(null,null);
        }

        ResultVO resultVO = new ResultVO();
        /**
         * check and save data
         */
        List<SfzjCxjmxnhjcxx> insertDwjbxxGrid = cxjmxndwVO.getInsertDwjbxxGrid();
        if(insertDwjbxxGrid != null && insertDwjbxxGrid.size() > 0) {
            List<CxjmxnhjErrorMsg> insertErrList = cxjmxnhjcxxService.checkAndSave(insertDwjbxxGrid,resultVO);
            resultVO.setInsertMsg(insertErrList);
        }

        /**
         * check and update
         */
        List<CxjmxnhjccDto> updateDwjbxxGrid = cxjmxndwVO.getUpdateDwjbxxGrid();
        if(updateDwjbxxGrid != null && updateDwjbxxGrid.size() > 0) {
            List<CxjmxnhjErrorMsg> updateErrList = cxjmxnhjcxxService.checkAndUpdate(updateDwjbxxGrid,resultVO);
            resultVO.setUpdateMsg(updateErrList);
        }

        /**
         * check and delete
         */
        List<SfzjCxjmxnhjcxx> deleteDwjbxxGrid = cxjmxndwVO.getDeleteDwjbxxGrid();
        if(deleteDwjbxxGrid != null && deleteDwjbxxGrid.size() > 0) {
            List<CxjmxnhjErrorMsg> deleteErrList = cxjmxnhjcxxService.checkAndDelete(deleteDwjbxxGrid,resultVO);
            resultVO.setDeleteMsg(deleteErrList);
        }

        return Response.success(null,resultVO);

    }
}
