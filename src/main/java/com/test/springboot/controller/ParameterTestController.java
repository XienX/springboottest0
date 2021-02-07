package com.test.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{name}") //car/2/owner/zhangsan
    public Map<String, Object> getCar(@PathVariable("id") Integer id,@PathVariable("name") String name,
                                      @PathVariable Map<String, String> pv) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        return map;
    }
}
