package com.backstage.base.service.impl;

import com.backstage.base.models.User;
import com.backstage.base.service.UserManagement;
import com.backstage.base.mapper.UserManagementMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserlManagementService implements UserManagement {

	private final Logger LOG = Logger.getLogger(this.getClass());

	@Resource
	private UserManagementMapper userManagementMapper;

	@Override
	public int insert(User user) {
		return userManagementMapper.insert(user);
	}


	@Override
	public User queryByName(String name) {
		return userManagementMapper.selectByUserName(name);
	}

}