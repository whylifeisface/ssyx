package org.example.ssym.controller;

//import org.example.common.result;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.ssyx.common.result.Result;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/admin/acl/index")
public class IndexController {
    //登录接口
    @PostMapping("/login")
    public Result login() {
//        生成token
        HashMap<String, String> map = new HashMap<>();
        map.put("token", "token-admin");
        return Result.ok(map);
    }
    //获得用户信息
    @GetMapping("/info")
    public Result info(){
        Map<String, String> map = new HashMap<>();
        map.put("name","admin");
        map.put("avater", "");
        return Result.ok(map);
    }

    @PostMapping("/logout")
    public Result logout(){
        return Result.ok(null);
    }
}
