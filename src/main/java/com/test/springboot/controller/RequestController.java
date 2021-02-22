package com.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "gotoSuccess");
        request.setAttribute("code", "311");
        return "forward:/success"; //转发到success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) Integer code,
                       HttpServletRequest request){
        Object m = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        map.put("msg_reqMethod", m);

        Object Map = request.getAttribute("Map");
        Object Model = request.getAttribute("Model");
        Object HttpServletRequest = request.getAttribute("HttpServletRequest");
        map.put("Map", Map);
        map.put("Model", Model);
        map.put("HttpServletRequest", HttpServletRequest);

        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("Map", "map");
        model.addAttribute("Model", "model");
        request.setAttribute("HttpServletRequest", "request");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:/success";
    }
}
