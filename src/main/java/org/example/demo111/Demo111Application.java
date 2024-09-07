package org.example.demo111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//2024.8.31,在 SpringBoot 应用程序启动时，排除 jdbc 的自动装配机制即可，在程序入口文件中新增配置注解 “ exclude=DataSourceAutoConfiguration.class ”
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class )
public class Demo111Application {
    //

    public static void main(String[] args) {
        SpringApplication.run(Demo111Application.class, args);
    }

}
