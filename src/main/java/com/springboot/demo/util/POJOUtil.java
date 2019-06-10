package com.springboot.demo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 针对POJO类提供的帮助类
 *
 * @Author wangchungang@artspring.com.cn
 */
//@Slf4j
public class POJOUtil {

    private static Logger log = LoggerFactory.getLogger(POJOUtil.class);

    /**
     * 将json格式的值传递的给对象
     *
     * @param jsonObject
     * @param entity
     */
    public static void setValuesByJSON(JSONObject jsonObject, Object entity) throws Exception {
        Iterator keyIter = jsonObject.keySet().iterator();
        while (keyIter.hasNext()) {
            String sKey = keyIter.next().toString();
            String sValue = jsonObject.getString(sKey);

            // 忽略不存在的属性
            Field field = getField(entity.getClass(), sKey);
            if (field == null)
                continue;

            setValue(entity, sKey, sValue);
        }
    }

    /**
     * 将POJO类转换成snakeCase风格的JSON
     * @param entity
     * @return
     * @throws Exception
     */
    public static JSONObject convertToSnakeCaseJSON(Object entity) throws Exception{
        JSONObject camelCaseJSON = POJOUtil.convertToJSON(entity);
        JSONObject snakeCaseJSON = new JSONObject();
        for(Map.Entry<String, Object> entry : camelCaseJSON.entrySet()){
            String camelCaseKey = entry.getKey();
            String snakeCaseKey = POJOUtil.parseFieldNameToSnakeCase(camelCaseKey);
            snakeCaseJSON.put(snakeCaseKey, entry.getValue());
        }
        return snakeCaseJSON;
    }

    /**
     * 将对象转成JSON对象
     *
     * @param entity
     * @throws Exception
     */
    public static JSONObject convertToJSON(Object entity) throws Exception {
        JSONObject jsonObject = new JSONObject();

        Map hmValues = _getAllValues(entity);
        Iterator keyIter = hmValues.keySet().iterator();
        while (keyIter.hasNext()) {
            String sKey = (String) keyIter.next();
            Object oValue = hmValues.get(sKey);
            String sValue = "";
            if (oValue != null) {
                sValue = oValue.toString();
                if (oValue instanceof Date) {
                    // 将日期转成标准格式
                    sValue = TimeUtils.getFormatDateDay((Date) oValue);
                }
            }

            jsonObject.put(sKey, sValue);
        }

        return jsonObject;
    }

    /**
     * 根据传入的同名参数的Map对象设置对象属性值
     *
     * @param entity
     * @param paramsContext
     */
    public static void setValuesByParams(Object entity, Map<String, Object> paramsContext, boolean ignoreIdParam) {
        Iterator keyIter = paramsContext.keySet().iterator();
        while (keyIter.hasNext()) {
            String sParamName = (String) keyIter.next();
            if (ignoreIdParam && sParamName.trim().equalsIgnoreCase("id"))
                continue;

            if (isField(entity, sParamName)) {
                //
                Object oParamValue = paramsContext.get(sParamName);
                if (oParamValue == null) continue;

                if (oParamValue instanceof String[]) {
                    //
                    String[] paramValuesStringArray = (String[]) oParamValue;
                    Object[] paramValuesArray = new Object[paramValuesStringArray.length];
                    for (int i = 0; i < paramValuesStringArray.length; i++) {
                        paramValuesArray[i] = paramValuesStringArray[i];
                    }
                    setValue(entity, sParamName, StringUtils.join(paramValuesArray, ','));
                } else {
                    setValue(entity, sParamName, oParamValue);
                }
            }
        }
    }

    /**
     * 根据传入的同名参数的Map对象设置对象属性值
     *
     * @param entity
     * @param paramsContext
     * @param _ignoreParams 需要忽略的参数
     */
    public static void setValuesByParams(Object entity, Map<String, Object> paramsContext,
                                         String[] _ignoreParams) {
        setValuesByParams(entity, paramsContext, _ignoreParams, true);
    }

    /**
     * 根据传入的同名参数的Map对象设置对象属性值
     *
     * @param entity
     * @param paramsContext
     * @param _ignoreParams 需要忽略的参数
     */
    public static void setValuesByParams(Object entity, Map<String, Object> paramsContext,
                                         String[] _ignoreParams, boolean ignoreIdParam) {
        Iterator keyIter = paramsContext.keySet().iterator();
        while (keyIter.hasNext()) {
            String sParamName = (String) keyIter.next();
            if (sParamName.trim().equalsIgnoreCase("id") && ignoreIdParam)
                continue;

            if (inString(sParamName.trim(), true, _ignoreParams)) {
                continue;
            }

            if (isField(entity, sParamName)) {
                //
                Object oParamValue = paramsContext.get(sParamName);
                if (oParamValue instanceof String[]) {
                    //
                    setValue(entity, sParamName, StringUtils.join((String[]) oParamValue, ","));
                } else {
                    setValue(entity, sParamName, oParamValue);
                }
            }
        }
    }


    /**
     * 将对象转成JSON对象
     *
     * @param entity
     * @throws Exception
     */
    public static JSONObject convertBaseEntityToJSON(Object entity) throws Exception {
        JSONObject jsonObject = new JSONObject();

        Map hmValues = getAllValuesForBaseEntity(entity);
        Iterator keyIter = hmValues.keySet().iterator();
        while (keyIter.hasNext()) {
            String sKey = (String) keyIter.next();
            Object oValue = hmValues.get(sKey);
            String sValue = "";
            if (oValue != null) {
                sValue = oValue.toString();
                if (oValue instanceof Date) {
                    // 将日期转成标准格式
                    sValue = TimeUtils.getFormatDateDay((Date) oValue);
                    String sValue1 = TimeUtils.getFormatDateDay((Date) oValue, "");
                    jsonObject.put(sKey + "_full_", sValue1);
                }
            }

            jsonObject.put(sKey, sValue);
        }

        return jsonObject;
    }

    public static Map getAllValuesForBaseEntity(Object baseEntity) {
        HashMap hmValues = new HashMap();

        // 将subscriptReport的所有get属性都放到model中
        Method[] methods = getAllDeclaredMethod(baseEntity);
        for (Method aMethod : methods) {
            String sMethodName = aMethod.getName();
            //todo 设置boolean类型数据时有bug
            if (!sMethodName.startsWith("get") || aMethod.getTypeParameters().length > 0 || aMethod.isAccessible()
                    || sMethodName.startsWith("getAllValues") || sMethodName.startsWith("getValue")
                    || sMethodName.startsWith("getField") || sMethodName.startsWith("getClass"))
                continue;
            if(Modifier.isStatic(aMethod.getModifiers())) continue;
            String sModelKey = sMethodName.substring("get".length(), sMethodName.length());
            StringBuilder stringBuilder = new StringBuilder(sModelKey.length());
            for (int i = 0; i < sModelKey.length(); i++) {
                char c = sModelKey.charAt(i);
                if (i == 0) {
                    stringBuilder.append(Character.toLowerCase(c));
                } else {
                    stringBuilder.append(c);
                }
            }
            sModelKey = stringBuilder.toString();

            Object methodValue = "";
            try {
                methodValue = aMethod.invoke(baseEntity);
            } catch (Exception e) {
                //System.out.println("sMethodName:" + sMethodName);
                e.printStackTrace();
            }
            // 不转换Date
            // if (methodValue instanceof Date) {
            // methodValue = DateUtils.toString((Date) methodValue, "yyyy-MM-dd HH:mm:ss");
            // }
            hmValues.put(sModelKey, methodValue);
        }
        return hmValues;
    }

    public static Map getAllValuesForBaseEntity(Object baseEntity, String[] pIgnoreParams, boolean ignoreCase) {
        HashMap hmValues = new HashMap();
        // 将subscriptReport的所有get属性都放到model中
        Method[] methods = getAllDeclaredMethod(baseEntity);
        for (Method aMethod : methods) {
            String sMethodName = aMethod.getName();
            if (!sMethodName.startsWith("get") || aMethod.getTypeParameters().length > 0 || aMethod.isAccessible()
                    || sMethodName.startsWith("getAllValues") || sMethodName.startsWith("getValue")
                    || sMethodName.startsWith("getField") || sMethodName.startsWith("getClass"))
                continue;
            String sModelKey = sMethodName.substring("get".length(), sMethodName.length());
            StringBuilder stringBuilder = new StringBuilder(sModelKey.length());
            for (int i = 0; i < sModelKey.length(); i++) {
                char c = sModelKey.charAt(i);
                if (i == 0) {
                    stringBuilder.append(Character.toLowerCase(c));
                } else {
                    stringBuilder.append(c);
                }
            }
            sModelKey = stringBuilder.toString();
            if (inString(sModelKey, ignoreCase, pIgnoreParams)) {
                continue;
            }

            Object methodValue = "";
            try {
                methodValue = aMethod.invoke(baseEntity);
            } catch (Exception e) {
                //System.out.println("sMethodName:" + sMethodName);
                e.printStackTrace();
            }
            // 不转换Date
            // if (methodValue instanceof Date) {
            // methodValue = DateUtils.toString((Date) methodValue, "yyyy-MM-dd HH:mm:ss");
            // }
            hmValues.put(sModelKey, methodValue);
        }
        return hmValues;
    }


    public static Map _getAllValues(Object object) {
        HashMap hmValues = new HashMap();
        // 将subscriptReport的所有get属性都放到model中
        Method[] methods = object.getClass().getMethods();
        for (Method aMethod : methods) {
            String sMethodName = aMethod.getName();
            if (!sMethodName.startsWith("get") || aMethod.getTypeParameters().length > 0 || aMethod.isAccessible()
                    || sMethodName.startsWith("getAllValues") || sMethodName.startsWith("getValue")
                    || sMethodName.startsWith("getField") || sMethodName.startsWith("getClass"))
                continue;

            String sModelKey = sMethodName.substring("get".length(), sMethodName.length());
            StringBuilder stringBuilder = new StringBuilder(sModelKey.length());
            for (int i = 0; i < sModelKey.length(); i++) {
                char c = sModelKey.charAt(i);
                if (i == 0) {
                    stringBuilder.append(Character.toLowerCase(c));
                } else {
                    stringBuilder.append(c);
                }
            }
            sModelKey = stringBuilder.toString();

            Object methodValue = "";
            try {
                methodValue = aMethod.invoke(object);
            } catch (Exception e) {
                //System.out.println("sMethodName:" + sMethodName);
                e.printStackTrace();
            }
            // 不转换Date
            // if (methodValue instanceof Date) {
            // methodValue = DateUtils.toString((Date) methodValue, "yyyy-MM-dd HH:mm:ss");
            // }
            hmValues.put(sModelKey, methodValue);
        }
        return hmValues;
    }

    public String getValue(String fieldName) {
        try {
            Field field = this.getField(this.getClass(), fieldName);
            if (field == null)
                throw new NullPointerException("获取字段" + fieldName + "为空！");
            field.setAccessible(true);
            Object obj = field.get(this);
            field.setAccessible(false);
            if (obj == null)
                return "";
            return obj.toString();
        } catch (Exception e) {
            // LOG.error(this.getClass() + ": get column[" + fieldName +
            // "] err,"
            // + e.toString());
            e.printStackTrace();
        }
        return null;
    }

    public static void setValue(Object pojo, String fieldName, Object value) {
        if(value==null) return;

        try {
            // getDeclaredField不包括继承的字段,只搜寻*Declared*;而getField只搜寻所有public
            // fields.
            Field field = getField(pojo.getClass(), fieldName);
            if (field == null)
                throw new NullPointerException("获取字段" + fieldName + "为空！");

            Class<?> type = field.getType();

            String sTypeName = type.getName();
            if (sTypeName.equals("int") || sTypeName.equals("java.lang.Integer")) {
                Integer valueObj = NumberUtils.toInt(value.toString(), 0);
                field.setAccessible(true);
                field.set(pojo, valueObj);
                field.setAccessible(false);
            } else if (sTypeName.equals("java.lang.String")) {
                String valueObj = value.toString();
                field.setAccessible(true);
                field.set(pojo, valueObj);
                field.setAccessible(false);
            } else if (sTypeName.equals("long") || sTypeName.equals("java.lang.Long")) {
                Long valueObj = NumberUtils.toLong(value.toString(), 0L);
                field.setAccessible(true);
                field.set(pojo, new Long(valueObj));
                field.setAccessible(false);
            } else if (sTypeName.equals("boolean") || sTypeName.equals("java.lang.Boolean")) {
                Boolean valueObj = BooleanUtils.toBoolean(value.toString());// Boolean.getBoolean(value.toString());
                field.setAccessible(true);
                field.setBoolean(pojo, valueObj);
                field.setAccessible(false);
            } else if (sTypeName.equals("float") || sTypeName.equals("java.lang.Float")) {
                Float valueObj = NumberUtils.toFloat(value.toString(), 0f);
                field.setAccessible(true);
                field.set(pojo, valueObj);
                field.setAccessible(false);
            } else if ((Date.class == type) || (Date.class == type)) {
                // TODO 目前只支持"yyyy.MM.dd"和"yyyy.MM.dd HH:mm:ss"
                String str = value.toString();
                Date valueObj = null;
                if (value instanceof Date) {
                    valueObj = (Date) value;
                } else {
                    //转换Date
                    try {
                        valueObj = java.sql.Date.valueOf(str);
                    } catch (Exception e1) {
                        try {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                            valueObj = dateFormat.parse(str);
                        } catch (Exception e2) {
                            try {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                valueObj = dateFormat.parse(str);
                            } catch (Exception ex) {
                            }
                        }
                    }
                }

                field.setAccessible(true);
                field.set(pojo, valueObj);
                field.setAccessible(false);
            } else if (sTypeName.equals("double") || sTypeName.equals("java.lang.Double")) {
                Double valueObj = NumberUtils.toDouble(value.toString(), 0.0d);
                field.setAccessible(true);
                field.set(pojo, valueObj);
                field.setAccessible(false);
            } else {
                Object valueObj = type.cast(value);
                field.setAccessible(true);
                field.set(pojo, valueObj);
                field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Exception("设置字段值[fieldname:"+fieldName+"; fieldvalue:"+value+"]失败", e).printStackTrace();
            // LOG.error(this.getClass() + ": set column[" + fieldName +
            // "] err,"
            // + e.toString());
        }
    }

    public static boolean isField(Object object, String name) {
        try {
            Field field = getField(object.getClass(), name);
            return field != null;
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Field getField(Class<?> cls, String name) throws NoSuchFieldException {
        if (cls == null)
            return null;
        if (cls == Object.class) {
            return null;
        }

        Field field = null;
        if (cls.isInstance(new Object()))
            throw new NoSuchFieldException("FiledName is " + name);
        else {
            try {
                try {
                    field = cls.getDeclaredField(name);
                } catch (NoSuchFieldException ex) {
                }
                if (field == null) { // 开始尝试忽略大小写
                    Field[] fields = cls.getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field aField = fields[i];
                        if (log.isDebugEnabled()) {
                            //System.out.println("aField.getName():" + aField.getName());
                        }

                        if (aField.getName().equalsIgnoreCase(name)) {
                            field = aField;
                            break;
                        }
                    }
                }

                if (field == null) {
                    throw new NoSuchFieldException("Class[" + cls + "] no such Field[" + name + "]");
                }
            } catch (NoSuchFieldException e) {
                field = getField(cls.getSuperclass(), name);
            }
        }
        return field;
    }


    /**
     * 变量是否在指定的变量数组中
     *
     * @param paramName
     * @param ignoreCase      忽略大小写
     * @param paramNamesArray
     * @return
     */
    private static boolean inString(String paramName, boolean ignoreCase, String[] paramNamesArray) {
        if (paramNamesArray == null || paramNamesArray.length == 0)
            return false;

        for (String currParamName : paramNamesArray) {
            boolean isInString = false;
            currParamName = currParamName.trim();
            if (ignoreCase) {
                isInString = Objects.equals(currParamName.toLowerCase().trim(), paramName.toLowerCase().trim());
            } else {
                isInString = Objects.equals(currParamName.trim(), paramName.trim());
            }

            if (isInString) { //在数组中可以终止判断了
                return isInString;
            }
        }
        return false;
    }

    public static Object getFieldValue(Object entity, String fieldName) {
        Method[] methods = entity.getClass().getMethods();
        for (Method aMethod : methods) {
            String sMethodName = aMethod.getName();
            if (!sMethodName.startsWith("get") || aMethod.getTypeParameters().length > 0 || aMethod.isAccessible()
                    || sMethodName.startsWith("getAllValues") || sMethodName.startsWith("getValue")
                    || sMethodName.startsWith("getField") || sMethodName.startsWith("getClass"))
                continue;

            String sModelKey = sMethodName.substring("get".length(), sMethodName.length());
            if (!fieldName.trim().equalsIgnoreCase(sModelKey.trim())) {
                continue;
            }

            Object methodValue = "";
            try {
                methodValue = aMethod.invoke(entity);
            } catch (Exception e) {
                //System.out.println("sMethodName:" + sMethodName);
                e.printStackTrace();
            }
            return methodValue;
        }
        return null;
    }

    /**
     * 将pojo的字段名转成snake_case的风格
     *
     * @param pojoFieldName
     * @return
     */
    public static String parseFieldNameToSnakeCase(String pojoFieldName) {
        int defaultCapacity = (int) (pojoFieldName.length() * 1.5);
        StringBuilder stringBuilder = new StringBuilder(defaultCapacity);
        for (int i = 0; i < pojoFieldName.length(); i++) {
            char c = pojoFieldName.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    stringBuilder.append('_');
                }
                stringBuilder.append(Character.toLowerCase(c));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 将pojo的字段名转成camel_case的风格
     *
     * @param pojoFieldName
     * @return
     */
    public static String parseFieldNameToCamelCase(String pojoFieldName) {
        int defaultCapacity = pojoFieldName.length();
        StringBuilder stringBuilder = new StringBuilder(defaultCapacity);
        boolean isSnakeCaseChar = false;
        for (int i = 0; i < pojoFieldName.length(); i++) {
            char c = pojoFieldName.charAt(i);
            if (c == '_') {
                //忽略，并标记下一个字符为snakeCaseChar
                isSnakeCaseChar = true;
                continue;
            }

            if (isSnakeCaseChar) {
                stringBuilder.append(Character.toUpperCase(c));
                isSnakeCaseChar = false;
                continue;
            }


            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 循环向上转型, 获     * @param object : 子类对象
     *
     * @param methodName     : 父类中的方法名
     * @param parameterTypes : 父类中的方法参数类型
     * @return 父类中的方法对象
     */
    public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        Method method = null;

        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {
                //这里甚么都不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会进入
            }
        }

        return null;
    }

    public static Method[] getAllDeclaredMethod(Object object) {
        Map<String, Method> methodsMap = new HashMap<String, Method>(200);
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Method[] methods = clazz.getMethods();
                if (methods == null) continue;

                for (Method method : methods) {
                    if (methodsMap.containsKey(method.getName())) continue;
                    methodsMap.put(method.getName(), method);
                }
            } catch (Exception e) {
                //这里甚么都不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会进入
            }
        }

        Method[] methodsArray = new Method[methodsMap.size()];
        int nIndex = 0;
        for (Map.Entry<String, Method> methodEntry : methodsMap.entrySet()) {
            methodsArray[nIndex++] = methodEntry.getValue();
        }

        return methodsArray;
    }
}
