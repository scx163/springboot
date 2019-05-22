package com.backstage.base.service;

import com.backstage.base.models.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserManagement {

	int insert(User user);


	User queryByName(String name);
}
