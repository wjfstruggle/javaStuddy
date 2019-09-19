package com.cdc.fastJson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author wujf
 * @ClassName JSONObject
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
public class JSONObjectMethod {
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
//        testJSONStrToJSONObject();
//        testJSONStrToJSONArray();
        testJSONStrToJSONArrayComplex();
    }
    // 对象的解析
    static void testJSONStrToJSONObject() {
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));
    }
    // 数组的解析
    static void testJSONStrToJSONArray() {
        JSONArray jsonarray = JSONObject.parseArray(JSON_ARRAY_STR);
        for (Object o : jsonarray) {
            JSONObject jsonObject = (JSONObject) o;
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
    }
    // 复杂格式json字符串
    static void testJSONStrToJSONArrayComplex(){
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        System.out.println("teacherName: "  + teacherName + ": " + "teacherAge: "+ teacherAge);
        JSONObject jsonObjectCourse = jsonObject.getJSONObject("course");
        String courseName = jsonObjectCourse.getString("jsonObjectCourse");
        Long code = jsonObjectCourse.getLong("code");
        System.out.println("courseName: " + courseName + " " + "code: "+ code);

        JSONArray jsonObjectStudent = jsonObject.getJSONArray("students");
        for (Object o : jsonObjectStudent) {
            JSONObject jsonObject1 = (JSONObject) o;
            System.out.println("studentName:  " + jsonObject1.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject1.getInteger("studentAge"));
        }

        String jsonString = JSONObject.toJSONString(jsonObject);
        System.out.println("转换成json"+jsonString);
    }
}
