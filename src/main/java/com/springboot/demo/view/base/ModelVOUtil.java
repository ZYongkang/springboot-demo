package com.springboot.demo.view.base;

import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.util.Dict;
import com.springboot.demo.util.POJOUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 基于实体类的VO对象的工具类.
 * @Author wangchungang@artspring.com.cn
 */
public class ModelVOUtil {

    public static void loadParamIntoVOFromDO(Object modelDO, IModelVO modelVO){
        if(modelDO==null){
            return;
        }

        //从DO对象装载本类，采用相同命名规则的属性自动复制过来
        Map<String, Object> allValues = POJOUtil.getAllValuesForBaseEntity(modelDO);
        boolean ignoreIdParam = false;
        POJOUtil.setValuesByParams(modelVO, allValues, ignoreIdParam);
    }

    public static void convertVOToDO(IModelVO modelVO, Object modelDO){
        if(modelDO==null){
            return;
        }

        //从DO对象装载本类，采用相同命名规则的属性自动复制过来
        Map<String, Object> allValues = POJOUtil.getAllValuesForBaseEntity(modelVO);
        boolean ignoreIdParam = false;
        POJOUtil.setValuesByParams(modelDO, allValues, ignoreIdParam);
    }

    public static JSONObject toJSON(IModelVO modelVO){
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> valuesAsMap = POJOUtil.getAllValuesForBaseEntity(modelVO);
        for(Map.Entry<String, Object> value : valuesAsMap.entrySet()){
            String fieldName = value.getKey();
            Object fieldValue = value.getValue();
            String snakeCaseFieldName = POJOUtil.parseFieldNameToSnakeCase(fieldName);
            if(snakeCaseFieldName.endsWith("_fdfspath") ){
                String fieldValueAsString = (fieldValue==null) ? "" : fieldValue.toString();
                if(!Objects.equals(fieldValueAsString.trim(), "")){
                    fieldValueAsString = Dict.IMG_URL_PREFIX + fieldValueAsString;
                    if (fieldValueAsString.equals(Dict.IMG_URL_PREFIX + "null")) {
                        fieldValueAsString = "";
                    }
                    jsonObject.put(snakeCaseFieldName, fieldValueAsString);
                    continue;
                }
            }
            if(snakeCaseFieldName.endsWith("_url") ){
                String fieldValueAsString = (fieldValue==null) ? "" : fieldValue.toString();
                if(!fieldValueAsString.trim().startsWith("http")){
                    fieldValueAsString = Dict.IMG_URL_PREFIX + fieldValueAsString;
                    if (fieldValueAsString.equals(Dict.IMG_URL_PREFIX + "null")) {
                        fieldValueAsString = "";
                    }
                    if (fieldValueAsString.equals(Dict.IMG_URL_PREFIX)) {
                        fieldValueAsString = "";
                    }
                    jsonObject.put(snakeCaseFieldName, fieldValueAsString);
                    continue;
                }
            }
            if (snakeCaseFieldName.startsWith("gmt")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (fieldValue != null) {
                    String fieldValueAsString = sdf.format((Date) fieldValue);
                    jsonObject.put(snakeCaseFieldName, fieldValueAsString);
                    jsonObject.put(snakeCaseFieldName+"_long", ((Date) fieldValue).getTime());
                }
                continue;
            }
            if (fieldValue != null) {
                jsonObject.put(snakeCaseFieldName, fieldValue);
            }
        }

        return jsonObject;
    }
}
