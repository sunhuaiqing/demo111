package org.example.demo111.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.example.demo111.utils.HttpClientUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class Test01 {
    @Test
    public void test1() {
        System.out.println("开始执行测试用例：Test01()");
        //自定义add方法用来计算两个参数的和
        int res = 3 + 4;
        int expected = 7;
        //断言，如果参数的两个值一样，断言就通过，否则抛出异常
        Assert.assertEquals(res, expected);
        System.out.println("Test01()");
        System.out.println("");
    }


    @Test(dependsOnMethods = {"test3"}, priority = 1, groups = "sit")
    public void test2() {
        System.out.println("开始执行测试用例：test2()");
        System.out.println("this.toString()" + this.toString());
        System.out.println("");
    }


    @Test(priority = 0, enabled = true, groups = "success")
    public void test3() throws IOException {
        System.out.println("开始执行测试用例：test3()");
        //http get请求
        String url = "https://api.uomg.com/api/rand.qinghua";
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("interCode", "XXXX");
        String response = HttpClientUtil.doGet(url, parametersMap);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + parametersMap);
        System.out.println("http请求返参:" + response);
        System.out.println("");
    }


    @Test(priority = 0, enabled = true, groups = "smoke")
    public void test4_jf0001() throws IOException {

        //http post parameters请求
        System.out.println("开始执行测试用例：test4_jf0001()");
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("interCode", "jf0001");
        String url = "http://127.0.0.1:8791/jfInter";
        String response = HttpClientUtil.doPost(url, parametersMap);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + parametersMap);
        System.out.println("http请求返参:" + response);
        System.out.println("this.toString():" + this.toString());
        System.out.println("");
    }

    @Test(priority = 0, enabled = true, groups = "smoke")
    public void test6_jf0006_smsCodefail() throws IOException {
        //http post parameters请求
        System.out.println("开始执行测试用例：test6_jf0006_smsCodefail()");
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("interCode", "jf0006");
        parametersMap.put("optCode", "123456");
        parametersMap.put("smsCodeId", "111111");
        String url = "http://127.0.0.1:8791/jfInter";
        String response = HttpClientUtil.doPost(url, parametersMap);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + parametersMap);
        System.out.println("http请求返参:" + response);
        System.out.println("");
    }

    @Test(priority = 0, enabled = true, groups = "smoke")
    public void test6_jf0006_smsCodeSuccess() throws IOException {
        //http post parameters请求
        System.out.println("开始执行测试用例：test6_jf0006_smsCodSuccess()");
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("interCode", "jf0006");
        parametersMap.put("optCode", "123456");
        parametersMap.put("smsCodeId", "123456");
        String url = "http://127.0.0.1:8791/jfInter";
        String response = HttpClientUtil.doPost(url, parametersMap);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + parametersMap);
        System.out.println("http请求返参:" + response);
        System.out.println("");

    }


    @Test(priority = 0, enabled = true, groups = "smoke")
    public void test7_boc_smsCodefail() throws IOException {
        //http post parameters请求
        System.out.println("开始执行测试用例：test7_boc_smsCodefail()");
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("smscode", "444444");
        String url = "http://127.0.0.1:8791/bocMoke/checkVerificationCode";
        String response = HttpClientUtil.doPost(url, parametersMap);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + parametersMap);
        System.out.println("http请求返参:" + response);
        System.out.println("");
    }

    @Test(priority = 0, enabled = true, groups = "smoke")
    public void test8_boc_smsCodeSuccess() throws IOException {
        //http post parameters请求
        System.out.println("开始执行测试用例：test8_boc_smsCodeSuccess()");
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("smscode", "123456");
        String url = "http://127.0.0.1:8791/bocMoke/checkVerificationCode";
        String response = HttpClientUtil.doPost(url, parametersMap);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + parametersMap);
        System.out.println("http请求返参:" + response);
        System.out.println("");
    }

    @Test(priority = 0, enabled = true, groups = "smoke")
    public void test10_demo_post_Json_Success() throws IOException {
        //http post json请求
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("name", "sunhuaiqing" );
        jsonObject.put("age", "21" );
        Map<String, Object>  datainfo=  new HashMap<>();
        datainfo.put("route_auth_token", "aaaaaadddddddddf453fdgdfg" );
        datainfo.put("vbs_env_no", "218" );
        datainfo.put("bid", "234555" );
        datainfo.put("lending_time", "2024-08-12 12:00:00" );
        jsonObject.put("datainfo",datainfo);
        String url = "http://127.0.0.1:8791/index";
        String response = HttpClientUtil.doPost4Json(url, jsonObject);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + jsonObject);
        System.out.println("http请求返参:" + response);
        System.out.println("");
        // 将 JSON 字符串解析为 JSONObject 对象
        JSONObject jsonResponse = JSON.parseObject(response);
        // 从 JSONObject 中获取数据
        String returnCode = jsonResponse.get("returnCode").toString();
        String message = jsonResponse.get("message").toString();
        String data = jsonResponse.get("data").toString();
        System.out.println("http请求返参解析，returnCode:" + returnCode);
        System.out.println("http请求返参解析，message:" + message);
        System.out.println("http请求返参解析，data:" + data);
        System.out.println("");
        Assert.assertEquals(returnCode, "0000");
    }

    @Test(priority = 1, enabled = true, groups = "smoke")
    public void test11_demo_post_Json_fail() throws IOException {
        //http post json请求
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("name", "gaogao" );
        jsonObject.put("age", "39" );
        Map<String, Object>  datainfo=  new HashMap<>();
        datainfo.put("route_auth_token", "454dfsdfasf345d34" );
        datainfo.put("vbs_env_no", "232" );
        datainfo.put("bid", "667890" );
        datainfo.put("lending_time", "2023-08-12 12:00:00" );
        jsonObject.put("datainfo",datainfo);
        String url = "http://127.0.0.1:8791/index";
        String response = HttpClientUtil.doPost4Json(url, jsonObject);
        System.out.println("http请求地址：" + url);
        System.out.println("http请求入参：" + jsonObject);
        System.out.println("http请求返参:" + response);
        System.out.println("");

        // 将 JSON 字符串解析为 JSONObject 对象
        JSONObject jsonResponse = JSON.parseObject(response);
        // 从 JSONObject 中获取数据
        String returnCode = jsonResponse.get("returnCode").toString();
        String message = jsonResponse.get("message").toString();
        String data = jsonResponse.get("data").toString();
        System.out.println("http请求返参解析，returnCode:" + returnCode);
        System.out.println("http请求返参解析，message:" + message);
        System.out.println("http请求返参解析，data:" + data);
        System.out.println("");
        Assert.assertEquals(returnCode, "8888");

    }
}