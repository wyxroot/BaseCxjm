package com.foresee.ss.dsp.service.cxjm;

import com.foresee.ss.dsp.auto.dto.msg.CxjmgeyzPLMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmyzxx;
import com.foresee.ss.dsp.auto.vo.CxjmyzPLVO;

import java.util.List;

/**
 * 描述:
 * 两居应征批量数据交换业务层接口
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-02 11:14
 */
public interface CxjmyzxxPLService {

    /**
     * check and save
     *
     * @param cxjmyzPLVO
     */
    List<CxjmgeyzPLMsg> checkAndSave(CxjmyzPLVO<SfzjCxjmyzxx> cxjmyzPLVO);


    /**
     * save error data
     *
     * @param errorList
     */
    void saveErrorData(List<CxjmgeyzPLMsg> errorList);
}
