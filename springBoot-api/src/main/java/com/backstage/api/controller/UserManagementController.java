package com.backstage.api.controller;

import com.backstage.base.models.User;
import com.backstage.util.UUIDUtil;
import com.backstage.base.exception.XPFBadRequestException;
import com.backstage.base.response.XPFSingleResponse;
import com.backstage.base.service.UserManagement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(description = "用户管理接口")
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserManagementController {

    @Resource
    private UserManagement userManagement;

    @ApiOperation(value ="根据用户姓名查询用户信息")
    @GetMapping(value = "/getByName")
    @ResponseBody
    public Object getByName(String username) throws XPFBadRequestException {
        User user =  userManagement.queryByName(username);
        return user;
    }

    @ApiOperation(value = "新增用户")
    @GetMapping(value = "/add")
    @ResponseBody
    public Object add()  {
        User user = new User();
        user.setUsername("dy");
        user.setPassword("123456");
        user.setEmail("1");
        user.setImage("12");
        user.setLastIp("12.2.2.2");
        user.setuserUuid(UUIDUtil.getUUID());
        if(userManagement.insert(user) > 0){
            return new XPFSingleResponse("用户新增成功");
        }
        return new XPFBadRequestException("用户新增失败");
    }
}