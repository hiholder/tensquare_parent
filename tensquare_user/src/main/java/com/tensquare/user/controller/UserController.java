package com.tensquare.user.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{userid}", method = RequestMethod.GET)
    public Result selectById(@PathVariable String userid) {
        User user = userService.selectById(userid);
        return new Result(true, StatusCode.OK, "查询成功", user);
    }
    /*@RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        User result = userService.login(user);
        if (result != null) {
            return new Result(true, StatusCode.OK, "登录成功",
                    result);
        } return new Result(false, StatusCode.OK, "登录失败");
    }*/
}

