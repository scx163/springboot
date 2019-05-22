package com.backstage.api.controller;

import com.backstage.base.exception.XPFBadRequestException;
import com.backstage.base.models.User;
import com.backstage.base.response.XPFSingleResponse;
import com.backstage.base.service.UserManagement;
import com.backstage.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(description = "授权接口")
@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @ApiOperation(value ="测试")
    @GetMapping(value = "/test")
    @ResponseBody
    public Object test() throws XPFBadRequestException {
        return "1212";
    }

}