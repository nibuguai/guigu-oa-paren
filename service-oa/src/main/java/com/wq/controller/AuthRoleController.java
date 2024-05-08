package com.wq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author 王骞
 * @Date 2023/7/13 17:27
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
@ResponseBody
@Slf4j
public class AuthRoleController {
    /**
     * 请求登录
     */
    @PostMapping("/login")
    public Object LoginCtl() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return map;
    }


    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public Object logout() {
        return "success";
    }


    /**
     * 登录成功获取主页全面
     */
    @GetMapping("/info")
    public Object info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("websocket",true);
        map.put("origins",new String[]{"*:*"});
        map.put("cookie_needed",false);
        map.put("entropy",1749875231);
        return map;
    }
}
