package com.foresee.ss.dsp.service;

import com.foresee.ss.dsp.auto.dao.SfzjCxjmgrcbxxMapper;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Title: <一句话描述>
 * </p>
 * <p>
 * Description: <详细描述>
 * </p>
 * <p>
 * Company: www.foresee.com.cn/
 * </p>
 *
 * @version 1.0 created on 2018/10/31 10:09
 * @author
 */
@Service
public class SbfsjjhptService {

    @Autowired
    private SfzjCxjmgrcbxxMapper sfzjCxjmgrcbxxMapper;


    public SfzjCxjmgrcbxx findOne() {
        return sfzjCxjmgrcbxxMapper.selectByPrimaryKey("7971DDEC3206005CE05396111F27E3D3");
    }
}
