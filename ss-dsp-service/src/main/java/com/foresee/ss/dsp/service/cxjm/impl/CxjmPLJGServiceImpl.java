package com.foresee.ss.dsp.service.cxjm.impl;

import com.foresee.ss.dsp.auto.dao.SfzjCxjmyzxxErrorMapper;
import com.foresee.ss.dsp.auto.dao.SfzjCxjmyzxxMapper;
import com.foresee.ss.dsp.auto.dto.CxjmPLCriteriaDto;
import com.foresee.ss.dsp.auto.dto.msg.CxjmPLResultMsg;
import com.foresee.ss.dsp.service.cxjm.CxjmPLJGService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 城乡居民批量结果查询业务层实现类
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-09 15:46
 */
@Service
public class CxjmPLJGServiceImpl implements CxjmPLJGService {

    private static final Logger logger = LoggerFactory.getLogger(CxjmPLJGServiceImpl.class);

    @Autowired
    private SfzjCxjmyzxxMapper cxjmyzxxMapper;

    @Autowired
    private SfzjCxjmyzxxErrorMapper cxjmyzxxErrorMapper;

    @Override
    public List<CxjmPLResultMsg> query(CxjmPLCriteriaDto criteriaDto) {
        List<CxjmPLResultMsg> resultList = new ArrayList<>();
        List<CxjmPLResultMsg> failList = new ArrayList<>();

        String cspch = criteriaDto.getCspch();

        try {
            resultList = cxjmyzxxMapper.findByCriteria(criteriaDto);
            failList = cxjmyzxxErrorMapper.findByCriteria(criteriaDto);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        resultList.addAll(failList);


        return resultList;
    }
}
