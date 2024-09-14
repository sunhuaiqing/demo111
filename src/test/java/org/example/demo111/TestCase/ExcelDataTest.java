package org.example.demo111.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.example.demo111.utils.ExcelDataUtil;
import org.example.demo111.utils.HttpClientUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataTest {
    @DataProvider(name = "loginUser")
    public Object[][] loginUserData() {
        //excel的文件名和类名一致，ExcelDataTest,测试方法和sheet名一致，testLogin
        ExcelDataUtil e = new ExcelDataUtil("ExcelDataTest", "testLogin");
        return e.getExcelData();
    }

    @Test(dataProvider = "loginUser", priority = 1, enabled = true, groups = "smoke")
    public void testLogin(HashMap<String, String> data) throws IOException {
        String userName = data.get("userName");
        String passWord = data.get("passWord");
        String age = data.get("age");
        String returnCode = data.get("returnCode");
        String mark = data.get("mark");
        System.out.println("[数据驱动]读取excel测试数据: " + userName + ", " + passWord + ", " + age + ", " + returnCode + ", " + mark);
        //http post json请求
        Map<String, Object> jsonObject = new HashMap<>();
        Map<String, Object> jsonObject1 = new HashMap<>();
        jsonObject.put("userName", userName);
        jsonObject.put("passWord", passWord);
        jsonObject.put("age", age);
        Map<String, Object> datainfo = new HashMap<>();
        datainfo.put("route_auth_token", "454dfsdfasf345d34");
        datainfo.put("vbs_env_no", "232");
        datainfo.put("bid", "667890");
        datainfo.put("lending_time", "2024-08-12 12:00:00");
        jsonObject.put("datainfo", datainfo);
        String url = "http://127.0.0.1:8791/index";
        String response = HttpClientUtil.doPost4Json(url, jsonObject);

        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + jsonObject.toString());
        System.out.println("http请求返参:" + response);
        // 将 JSON 字符串解析为 JSONObject 对象
        JSONObject jsonResponse = JSON.parseObject(response);
        String returnCode_response = jsonResponse.get("returnCode").toString();
        System.out.println("登录接口请求返回报文returnCode:" + returnCode_response + " ,excel用例的预期值returnCode：" + returnCode);
        System.out.println("");
        Assert.assertEquals(returnCode, returnCode_response);
    }
}
