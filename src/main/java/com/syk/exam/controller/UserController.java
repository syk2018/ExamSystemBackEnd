package com.syk.exam.controller;

import com.syk.exam.common.api.CommonResult;
import com.syk.exam.common.api.ResultCode;
import com.syk.exam.mbg.model.TbStudent;
import com.syk.exam.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "UsersController", description = "Users information api")
@Controller
@RequestMapping(value = "/rep/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("Login")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<TbStudent>> login(@RequestBody TbStudent user, HttpServletRequest request) {
        List<TbStudent> result = userService.login(user);
        if(!result.isEmpty()) {
            return CommonResult.success(result);
        }

        else {
            return CommonResult.validateFailed("Wrong account name or password.");
        }
    }

    @ApiOperation("SignUp")
    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult signUp(@RequestBody TbStudent user) {
        int result = userService.createUser(user);
        if(result == ResultCode.DUPLICATE.getCode()) {
            return CommonResult.duplicate("Duplicate username.");
        }
        else {
            List<TbStudent> temp = userService.getUserByUsername(user);
            return CommonResult.success(temp);
        }
    }
}
