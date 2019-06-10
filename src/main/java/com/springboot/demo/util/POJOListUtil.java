package com.springboot.demo.util;

import java.util.*;

/**
 * 针对POJO类List操作的帮助类
 * @Author wangchungang@artspring.com.cn
 */
public class POJOListUtil {

    /**
     * 对POJO的list根据属性进行分组
     * @param pojoList
     * @param fieldName
     * @return
     */
    public static Map<Object, List> groupList(List pojoList, String fieldName){
        if(pojoList==null || pojoList.isEmpty()){
            return null;
        }

        int capacity = (int) (pojoList.size()*1.3);
        Map<Object, List> groupedMap = new HashMap<Object, List>(capacity);
        for(Object pojo : pojoList){
            Object fieldValue = POJOUtil.getFieldValue(pojo, fieldName);
            if(fieldValue==null) continue;

            //获取分组后的List
            List groupedPojoList = null;
            if(!groupedMap.containsKey(fieldValue)){
                groupedPojoList = new ArrayList(pojoList.size());
                groupedMap.put(fieldValue, groupedPojoList);
            }
            else{
                groupedPojoList = groupedMap.get(fieldValue);
            }

            //添加pojo对象
            groupedPojoList.add(pojo);
        }
        return groupedMap;
    }

    /**
     * 根据指定字段的值对pojoList转成map对象。
     * 注意转对象时字段的值是不允许重复的。
     * 如果字段的值为空，默认以#+{id的值}作为key加入到分组中
     *
     * @param pojoList
     * @param fieldName
     * @return
     */
    public static Map<String,Object> toMap(List pojoList, String fieldName) {
        if(pojoList==null || pojoList.isEmpty()){
            return null;
        }

        int capacity = (int) (pojoList.size()*1.3);
        Map<String, Object> pojoMap = new HashMap<String, Object>(capacity);
        for(Object pojo : pojoList){
            Object fieldValue = POJOUtil.getFieldValue(pojo, fieldName);
            if(fieldValue==null || Objects.equals(fieldValue.toString().trim(), "")){
                fieldValue = "#"+POJOUtil.getFieldValue(pojo, "id");
            }
            pojoMap.put(fieldValue.toString().trim(), pojo);
        }
        return pojoMap;
    }

    public static Map<String,List> toGroupListMap(List pojoList,String fieldName){

        Map<String,List> map = new HashMap<>();
        for(Object pojo:pojoList){
            Object fieldValue = POJOUtil.getFieldValue(pojo, fieldName);
            //判断是否已经存在此内容
            if(map.containsKey(String.valueOf(fieldValue))){
                map.get(String.valueOf(fieldValue)).add(pojo);
            }else{
                List<Object> valdb = new ArrayList<>();
                valdb.add(pojo);
                map.put(String.valueOf(fieldValue), valdb);
            }
        }
        return map;
    }

    /**
     * 根据指定联合字段字段的值对pojoList转成map对象。
     * 注意转对象时字段的值是不允许重复的。
     * 如果多个字段联合后字段值仍然为空，默认以#+{id的值}作为key加入到分组中
     *
     * @param pojoList
     * @param fieldName
     * @return
     */
    public static Map<String,Object> toMap(List pojoList, String ... fieldName) {
        if(pojoList==null || pojoList.isEmpty()){
            return null;
        }

        int capacity = (int) (pojoList.size()*1.3);
        Map<String, Object> pojoMap = new HashMap<String, Object>(capacity);
        for(Object pojo : pojoList){
            StringBuilder stringBuilder = new StringBuilder(100);
            for(String fieldNameItem : fieldName){
                if(stringBuilder.length()>0){
                    stringBuilder.append("__"); //用两个__号连接字段间的值
                }
                Object fieldValue = POJOUtil.getFieldValue(pojo, fieldNameItem);
                if(fieldValue==null || Objects.equals(fieldValue.toString().trim(), "")){
                    continue;
                }
                stringBuilder.append(fieldValue.toString());
            }
            String fieldValues = stringBuilder.toString().trim();
            if(fieldValues==null || Objects.equals(fieldValues.toString().trim(), "")){
                fieldValues = "#"+POJOUtil.getFieldValue(pojo, "id");
            }
            pojoMap.put(fieldValues, pojo);
        }
        return pojoMap;
    }

    /**
     * 根据指定字段的值对pojoList进行过滤
     * @param pojoList
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public static List filter(List pojoList, String fieldName, Object fieldValue) {
        if(pojoList==null || pojoList.isEmpty()){
            return null;
        }

        List filteredList = new ArrayList(pojoList.size());
        for(Object pojo : pojoList){
            Object pojoFieldValue = POJOUtil.getFieldValue(pojo, fieldName);
            if(fieldValue instanceof String){
                //转字符串比较
                String pojoFieldValueString = pojoFieldValue==null ? "" : pojoFieldValue.toString().trim();
                String fieldValueString = fieldValue==null ? "" : ((String) fieldValue).trim();
                if(Objects.equals(pojoFieldValueString, fieldValueString)){
                    filteredList.add(pojo);
                }
                continue;
            }

            if(Objects.equals(pojoFieldValue, fieldValue)){
                filteredList.add(pojo);
            }
        }
        return filteredList;
    }

    /**
     * 将字段属性值转成List
     * @param pojoList
     * @param fieldName
     * @param isDistinct
     */
    public static List convertParamToList(List pojoList, String fieldName, boolean isDistinct) {
        if(pojoList==null || pojoList.isEmpty()){
            return null;
        }

        Set paramValueSet = new LinkedHashSet(pojoList.size());
        for(Object pojo : pojoList){
            Object pojoFieldValue = POJOUtil.getFieldValue(pojo, fieldName);
            if(pojoFieldValue==null) continue;
            if(isDistinct && paramValueSet.contains(pojoFieldValue)){
                continue;
            }
            paramValueSet.add(pojoFieldValue);
        }

        List paramValueList = new ArrayList(paramValueSet.size());
        paramValueList.addAll(paramValueSet);
        return paramValueList;
    }

    /**
     * 多字段之间展平，作为OR关系Map
     * @param pojoList
     * @param fieldNameArray
     * @return
     */
    public static Map<String,Object> toFlatMap(List pojoList, String ... fieldNameArray) {
        if(pojoList==null || pojoList.isEmpty()){
            return null;
        }
        int capacity = (int) (pojoList.size()*fieldNameArray.length*1.3);
        Map<String, Object> flatMap = new HashMap<String, Object>(capacity);
        for(Object pojo : pojoList){
            for(String fieldName : fieldNameArray) {
                Object fieldValue = POJOUtil.getFieldValue(pojo, fieldName);
                if (fieldValue == null || Objects.equals(fieldValue.toString().trim(), "")) {
                    fieldValue = "#" + POJOUtil.getFieldValue(pojo, "id");
                }
                flatMap.put(fieldValue.toString().trim(), pojo);
            }
        }
        return flatMap;
    }
}
