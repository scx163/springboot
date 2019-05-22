package com.backstage.base.mapper;

import com.backstage.base.models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserManagementMapper {

    int insert(User user);

    User selectByUserName(String name);

}