package org.example.demo111.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class HttpUtils {

    @Test
    public  void testkkk() throws IOException, InterruptedException {

        System.out.println("@@@：" );

        //第一种
        //以下是一个简单的例子，演示如何使用HttpClient发送GET请求：
        // 创建一个HttpClient实例
        HttpClient httpClient = HttpClient.newHttpClient();
        // 创建一个HTTP请求 指定URI
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.uomg.com/api/rand.qinghua")) // 使用 URI 创建请求
                .build();
        // 发送 HTTP 请求并获取响应
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        // 输出响应的状态码和响应体
        System.out.println("响应状态码：" + response.statusCode());
        System.out.println("响应体：" + response.body());



//第二种
//以下是一个示例，演示如何使用sendAsync()方法发送异步GET请求：
        HttpClient httpClient1 = HttpClient.newHttpClient();
        HttpRequest httpRequest1 = HttpRequest.newBuilder()
                .uri(URI.create("https://api.uomg.com/api/rand.qinghua"))
                .build();
        CompletableFuture<HttpResponse<String>> future = httpClient1.sendAsync(httpRequest1, HttpResponse.BodyHandlers.ofString());
        future.thenAccept(response1 -> {
            System.out.println("响应状态码：" + response1.statusCode());
            System.out.println("响应体：" + response1.body());
        }).join();// 等待异步操作完成


//第三种：
//以下是一个使用HttpClient发送POST请求的示例代码：




    }
}