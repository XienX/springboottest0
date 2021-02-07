package com.test.springboot.config;

import com.test.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：指明当前类是一个配置类；就是来替代之前的Spring配置文件
 * 代替在配置文件中用<bean>标签添加组件
 */
@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
