package com.test.springboot.controller;

import com.test.springboot.bean.Person;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{name}") //car/2/owner/zhangsan?age=18&inters=bb&inters=game
    public Map<String, Object> getCar(@PathVariable("id") Integer id, @PathVariable("name") String name,
                                      @PathVariable Map<String, String> pv,

                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,

                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam MultiValueMap<String, String> params

//                                      @CookieValue("Webstorm-1a44a5b7") String Webstorm,
//                                      @CookieValue("Webstorm-1a44a5b7") Cookie cookie,
                                      ){
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("name", name);
//        map.put("pv", pv);
//        map.put("userAgent",userAgent);
//        map.put("header", header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
//        map.put("Webstorm", Webstorm);
//        System.out.println(cookie.getName());

        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    // /cars/sell;low=34;brand=byd,audi,yd
    // /cars/sell;low=34;brand=byd;brand=audi;brand=yd
    //SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。removeSemicolonContent（移除分号内容）支持矩阵变量的
    //矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=20/2;age=10

    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }

    /**
     * 数据绑定，页面提交的数据都可以和对象属性进行绑定
     * @param person
     * @return
     */
    @PostMapping("saveuser")
    public Person saveuser(Person person){
        return person;
    }

}
