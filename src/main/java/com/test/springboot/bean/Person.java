package com.test.springboot.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties 将配置文件中配置的值，映射到组件中
 * @Component 只有这个组件是容器中的组件，才能提供@ConfigurationProperties功能
 * @ConfigurationProperties 默认从全局配置文件中获取值；
 */
@Component
@ConfigurationProperties(prefix = "person")
//@Validated // 数据校验，配合下面的的@Email等注解

//@PropertySource(value = {"classpath:person.properties"}) //加载指定的配置文件

@Data
public class Person {

    //@Value("${person.last-name}") // 可填入字面量/${key}从环境变量、配置文件中获取值/#{spEL}
    //@Email
    private String lastName;
//    @Value("#{10*5}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}
