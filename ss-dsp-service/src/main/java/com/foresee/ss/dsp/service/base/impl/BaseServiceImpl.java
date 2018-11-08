package com.foresee.ss.dsp.service.base.impl;

import cn.hutool.core.util.StrUtil;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;
import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.base.BaseService;
import com.foresee.ss.dsp.auto.base.mapper.BaseMapper;
import com.foresee.ss.dsp.auto.base.model.BaseModel;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrjcxx;
import com.foresee.ss.dsp.service.cxjm.impl.CxjmxnhjcxxServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 公共代码抽取类实现
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 14:15
 */
public abstract class BaseServiceImpl< T extends BaseModel> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String checkParam(T param) {

        if (param == null){
            return ErrorMsg.NOTNULL_DATA;
        }

        if ( StrUtil.isBlank(param.getXh()) ){
            return ErrorMsg.NOTNULL_XH;
        }

        if ( StrUtil.isBlank(param.getGrbh()) ){
            return ErrorMsg.NOTNULL_GRBH;
        }

        if ( StrUtil.isBlank(param.getXzqhxqDm()) ){
            return ErrorMsg.NOTNULL_XZQHXQ_DM;
        }

        if ( StrUtil.isBlank(param.getSjlylx()) ){
            return ErrorMsg.NOTNULL_SJLYLX;
        }

        if ( StrUtil.isBlank(param.getGrbhSw()) ){
            return ErrorMsg.NOTNULL_GRBH_SW;
        }

        //效验子类特有的数据, 子类自己实现
        return  checkMyParam(param);
    }

    public abstract  String checkMyParam(T param);

    @Override
    public List<CxjmgrxxErrorMsg> checkAndSave(List<T> paramList) {
        List<CxjmgrxxErrorMsg> insertError = new ArrayList<>();
        for (T model : paramList) {
            try {
                String result = checkParam(model);
                if(result == null){
                    //子类实现
                    baseMapper.insert(model);
                }else {
                    CxjmgrxxErrorMsg<SfzjCxjmgrjcxx> errorMsg = setErrorMsg(result,model);
                    insertError.add(errorMsg);
                }
            }catch (Exception e){
                logger.error(e.getMessage());
                //存储失败, 返回失败数据
                CxjmgrxxErrorMsg<SfzjCxjmgrjcxx> errorMsg = setErrorMsg("未知错误(请确认序号是否重复!)",model);
                insertError.add(errorMsg);
            }

        }
        return insertError;
    }






    @Override
    public List<CxjmgrxxErrorMsg> checkAndUpdate(List<T> updateList) {
        List<CxjmgrxxErrorMsg> updateError = new ArrayList<>();
        int i = 0;
        for (T t : updateList) {
            try {
                String result = checkParam(t);
                if (result == null){
                    i = baseMapper.updateByPrimaryKeySelective(t);
                    if (i != 1){
                        CxjmgrxxErrorMsg<SfzjCxjmgrcbxx> errorMsg = setErrorMsg("更新数据不存在",t);
                        updateError.add(errorMsg);
                    }
                }else{
                    CxjmgrxxErrorMsg<SfzjCxjmgrcbxx> errorMsg = setErrorMsg(result,t);
                    updateError.add(errorMsg);
                }

            }catch (Exception e){
                logger.error(e.getMessage());
                CxjmgrxxErrorMsg errorMsg = setErrorMsg("未知错误",t);
                updateError.add(errorMsg);
            }
        }
        return updateError;
    }


//    protected  T  setTparam(T t)throws Exception{
//
//        T t = getT();
//
//        t.setXh(t.getXh());
//        t.setGrbh(t.getGrbh());
//        t.setXzqhxqDm(t.getXzqhxqDm());
//        t.setSjlylx(t.getSjlylx());
//        t.setGrbhSw(t.getGrbhSw());
//
//        return t;
//    }
//
//    /**
//     * 反射获取泛型类实例
//     * @return
//     * @throws Exception
//     */
//    protected  T getT() throws Exception{
//       ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
//       Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//       Object o = Class.forName(actualTypeArguments[0].getTypeName()).newInstance();
//
//       return (T)o;
//    }







    /**
     *  子类自定义错误信息与错误参数
     * @param result
     * @param model
     * @return
     */
    public abstract CxjmgrxxErrorMsg setErrorMsg(String result, T model);
}
