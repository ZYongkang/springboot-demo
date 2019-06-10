package com.springboot.demo.view.base;

import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.util.Dict;
import com.springboot.demo.util.POJOUtil;
import com.springboot.demo.util.StringUtils;

/**
 * 基于实体类的VO对象的基类。
 * @author wangchungang@artspring.com.cn
 */
public abstract class AbstractModelVO implements IModelVO{

    /**
     * 从DO对象中装载同名属性
     * @param modelDO DO对象
     */
    public void loadParamFromDO(Object modelDO){
        ModelVOUtil.loadParamIntoVOFromDO(modelDO, this);
    }

    /**
     * 将VO同样命名规则的字段复制到DO中
     * @param modelDO
     */
    public void convertToDO(Object modelDO){
        ModelVOUtil.convertVOToDO(this, modelDO);
    }

    /**
     * 将VO对象转换成JSON对象
     * @return
     */
    public JSONObject toJSON(){
        return ModelVOUtil.toJSON(this);
    }

    /**
     * 设置单个属性的值
     * @param fieldName
     * @param fieldValue
     * @param isArtspringImg
     */
    public void setValue(String fieldName, Object fieldValue, boolean isArtspringImg){
        if(fieldValue==null) return;

        if(isArtspringImg){
            String fieldValueImg = fieldValue.toString();
            if(StringUtils.isEmpty(fieldValueImg)){
                POJOUtil.setValue(this, fieldName, "");
                return;
            }
            if(fieldValueImg.equals(Dict.IMG_URL_PREFIX)){
                POJOUtil.setValue(this, fieldName, "");
                return;
            }

            boolean isAbsoluteImg = fieldValueImg.startsWith("http://") || fieldValueImg.startsWith("https://");
            if(isAbsoluteImg){
                POJOUtil.setValue(this, fieldName, fieldValueImg);
            }
            else{
                POJOUtil.setValue(this, fieldName, Dict.IMG_URL_PREFIX+fieldValueImg);
            }
        }
        else{
            POJOUtil.setValue(this, fieldName, fieldValue);
        }
    }
}
