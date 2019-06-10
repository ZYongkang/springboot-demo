package com.springboot.demo.mybatis;

import com.springboot.demo.util.POJOUtil;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 16:26
 */
public class MybatisMapperFileTest {

    public static void main(String[] args) {

        String className = "com.springboot.demo.model.ArtworkDO";
        try {
            Class c = Class.forName(className);

            //新建ResultMap
            buildMybatisResultMap(className, c);

            //生成新建SQL
            buildMybatisInsertSQL(className, c);

            //生成更新SQL
            buildMybatisUpdateSQL(className, c);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void buildMybatisResultMap(String className, Class c) {
        String mapName = c.getSimpleName();
        StringBuilder stringBuilder = new StringBuilder(1024);
        for(int i=0; i<mapName.length(); i++){
            if(i==0){
                stringBuilder.append(Character.toLowerCase(mapName.charAt(i)));
            }
            else{
                stringBuilder.append(mapName.charAt(i));
            }
        }
        mapName = stringBuilder.append("Map").toString();
        stringBuilder = new StringBuilder("<resultMap id=\"").append(mapName).append("\" type=\"")
                .append(className).append("\">");
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
        System.out.println("<id column=\"id\" property=\"id\" />");

        Method[] methods = c.getDeclaredMethods();
        int nIndex = 0;
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String realMethodName = methodName.substring(3);
                String fieldNameSnakeCase = POJOUtil.parseFieldNameToSnakeCase(realMethodName);
                String fieldNameCamelCase = POJOUtil.parseFieldNameToCamelCase(fieldNameSnakeCase);
                if(fieldNameCamelCase.equals("id")) continue;

                stringBuilder.append("<result column=\"")
                        .append(fieldNameSnakeCase).append("\" property=\"")
                        .append(fieldNameCamelCase).append("\"").append("/>");
                System.out.println(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        System.out.println("</resultMap>");
    }

    private static void buildMybatisInsertSQL(String className, Class c) {
        //生成insert的SQL
        StringBuilder stringBuilder = new StringBuilder().append("<insert id=\"insert\" parameterType=\"")
                .append(className).append("\" useGeneratedKeys=\"true\" keyProperty=\"id\">");
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());

        String lineSep = System.getProperty("line.separator");
        System.out.println("INSERT INTO TABLE_NAME (");
        Method[] methods = c.getDeclaredMethods();
        int nIndex = 0;
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String realMethodName = methodName.substring(3);
                String fieldNameSnakeCase = POJOUtil.parseFieldNameToSnakeCase(realMethodName);
                String fieldNameCamelCase = POJOUtil.parseFieldNameToCamelCase(fieldNameSnakeCase);
                if(fieldNameCamelCase.equals("id")) continue;
                if(nIndex>0){
                    stringBuilder.append(",");
                }
                if(nIndex%10==0 && nIndex>0){
                    stringBuilder.append(lineSep);
                }
                stringBuilder.append(fieldNameSnakeCase);
                nIndex++;
            }
        }
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());

        System.out.println(") VALUES(");
        nIndex = 0;
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String realMethodName = methodName.substring(3);
                String fieldNameSnakeCase = POJOUtil.parseFieldNameToSnakeCase(realMethodName);
                String fieldNameCamelCase = POJOUtil.parseFieldNameToCamelCase(fieldNameSnakeCase);
                if(fieldNameCamelCase.equals("id")) continue;
                if(nIndex>0){
                    stringBuilder.append(",");
                }
                if(nIndex%10==0 && nIndex>0){
                    stringBuilder.append(lineSep);
                }
                if(!fieldNameCamelCase.startsWith("gmt")) {
                    stringBuilder.append("#{");
                    stringBuilder.append(fieldNameCamelCase);
                    stringBuilder.append("}");
                }
                else{
                    stringBuilder.append("now()");
                }
                nIndex++;
            }
        }
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());

        System.out.println(")");
        System.out.println("</insert>");
    }

    private static void buildMybatisUpdateSQL(String className, Class c) {
        //生成update的SQL
        StringBuilder stringBuilder = new StringBuilder().append("<update id=\"update\" parameterType=\"")
                .append(className).append("\">");
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
        System.out.println("UPDATE TABLE_NAME SET ");

        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String realMethodName = methodName.substring(3);
                String fieldNameSnakeCase = POJOUtil.parseFieldNameToSnakeCase(realMethodName);
                String fieldNameCamelCase = POJOUtil.parseFieldNameToCamelCase(fieldNameSnakeCase);
                if(fieldNameCamelCase.equals("gmtModified")) continue;
                if(fieldNameCamelCase.equals("gmtCreate")) continue;
                if(fieldNameCamelCase.equals("id")) continue;
                //System.out.println(fieldNameSnakeCase + " " + fieldNameCamelCase);
                stringBuilder.append("<if test=\"")
                        .append(fieldNameCamelCase).append(" != null");
                if(!method.getReturnType().equals(Date.class)
                        && !method.getReturnType().equals(Integer.class)
                        && !method.getReturnType().equals(Long.class)
                        && !method.getReturnType().equals(Float.class)
                        && !method.getReturnType().equals(Double.class)) {
                    stringBuilder.append(" and ").append(fieldNameCamelCase).append(" != ''");
                }
                stringBuilder.append("\">")
                        .append(fieldNameSnakeCase).append(" = #{").append(fieldNameCamelCase).append("},</if>");
                System.out.println(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        System.out.println("gmt_modified=now() WHERE id=#{id}");
        System.out.println("</update>");
    }

}
