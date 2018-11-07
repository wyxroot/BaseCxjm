package com.foresee.ss.dsp.service.cxjm;

import com.foresee.ss.dsp.auto.dto.msg.CxjmgeyzMsg;
import com.foresee.ss.dsp.auto.vo.CxjmyzVO;

import java.util.List;

/**
 * 描述:
 * 个人应征数据交换业务层
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 16:22
 */
public interface CxjmyzxxService {

    /**
     * 效验并保存个人应征信息数据
     * @param cxjmyzVO
     * @return
     */
    List<CxjmgeyzMsg> checkAndSave(List<CxjmyzVO> cxjmyzVO);
}
