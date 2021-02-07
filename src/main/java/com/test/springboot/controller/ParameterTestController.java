package com.test.springboot.controller;

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
}
