package com.foresee.ss.dsp.service.base.impl;

import com.foresee.ss.dsp.constant.ErrorMsg;
import com.foresee.ss.dsp.service.base.BaseService;
import com.foresee.ss.dsp.auto.base.dto.BaseDto;
import com.foresee.ss.dsp.auto.base.mapper.BaseMapper;
import com.foresee.ss.dsp.auto.base.model.BaseModel;
import com.foresee.ss.dsp.auto.dto.msg.CxjmgrxxErrorMsg;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrjcxx;
import com.foresee.icap.common.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 公共代码抽取类实现
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-03 14:15
 */
public abstract class BaseServiceImpl< T extends BaseModel, Dto extends BaseDto> implements BaseService< T, Dto> {

    @Autowired
    private BaseMapper<T> baseMapper;


    @Override
    public String checkInsParam(T param) {

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
                String result = checkInsParam(model);
                if(result == null){
                    //子类实现
                    baseMapper.insert(model);
                }else {
                    CxjmgrxxErrorMsg<SfzjCxjmgrjcxx> errorMsg = setErrorMsg(result,model);
                    insertError.add(errorMsg);
                }
            }catch (Exception e){
                e.printStackTrace();
                //存储失败, 返回失败数据
                CxjmgrxxErrorMsg<SfzjCxjmgrjcxx> errorMsg = setErrorMsg("未知错误(请确认序号是否重复!)",model);
                insertError.add(errorMsg);
            }

        }
        return insertError;
    }






    @Override
    public List<CxjmgrxxErrorMsg> checkAndUpdate(List<Dto> dtoList) {
        List<CxjmgrxxErrorMsg> updateError = new ArrayList<>();
        T t = null;
        int i = 0;
        for (Dto dto : dtoList) {
            try {
                String result = checkUpdateParam(dto);
                t = setTparam(dto);
                if (result == null){
                    i = baseMapper.updateByPrimaryKeySelective(t);
                }else{
                    CxjmgrxxErrorMsg<SfzjCxjmgrcbxx> errorMsg = setErrorMsg(result,t);
                    updateError.add(errorMsg);
                }
                if (i != 1){
                    CxjmgrxxErrorMsg<SfzjCxjmgrcbxx> errorMsg = setErrorMsg("更新数据不存在",t);
                    updateError.add(errorMsg);
                }
            }catch (Exception e){
                e.printStackTrace();
                CxjmgrxxErrorMsg errorMsg = setErrorMsg("未知错误",t);
                updateError.add(errorMsg);
            }
        }
        return updateError;
    }


    protected  T  setTparam(Dto dto)throws Exception{

        T t = getT();

        t.setXh(dto.getXh());
        t.setGrbh(dto.getGrbh());
        t.setXzqhxqDm(dto.getXzqhxqDm());
        t.setSjlylx(dto.getSjlylx());
        t.setGrbhSw(dto.getGrbhSw());

        return t;
    }

    /**
     * 反射获取泛型类实例
     * @return
     * @throws Exception
     */
    protected  T getT() throws Exception{
       ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
       Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
       Object o = Class.forName(actualTypeArguments[0].getTypeName()).newInstance();

       return (T)o;
    }




    protected  String checkUpdateParam(Dto dto){
        if (dto == null){
            return ErrorMsg.NOTNULL_DATA;
        }

        if ( StrUtil.isBlank(dto.getXh()) ){
            return ErrorMsg.NOTNULL_XH;
        }

        if ( StrUtil.isBlank(dto.getGrbh()) ){
            return ErrorMsg.NOTNULL_GRBH;
        }

        if ( StrUtil.isBlank(dto.getXzqhxqDm()) ){
            return ErrorMsg.NOTNULL_XZQHXQ_DM;
        }

        if ( StrUtil.isBlank(dto.getSjlylx()) ){
            return ErrorMsg.NOTNULL_SJLYLX;
        }

        if ( StrUtil.isBlank(dto.getGrbhSw()) ){
            return ErrorMsg.NOTNULL_GRBH_SW;
        }


        if(StrUtil.isBlank(dto.getBgxmMc())){
            return  ErrorMsg.NOTNULL_BGXM_MX;
        }

        if(StrUtil.isBlank(dto.getBgqz())){
            return  ErrorMsg.NOTNULL_BGQZ;
        }

        if(StrUtil.isBlank(dto.getBghz())){
            return ErrorMsg.NOTNULL_BGQH;
        }

        return null;
    }




    /**
     *  子类自定义错误信息与错误参数
     * @param result
     * @param model
     * @return
     */
    public abstract CxjmgrxxErrorMsg setErrorMsg(String result, T model);
}
