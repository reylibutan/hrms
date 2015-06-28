package com.reylibutan.tabularasa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reylibutan.tabularasa.dao.UserDAO;
import com.reylibutan.tabularasa.entity.User;
import com.reylibutan.tabularasa.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void save(User user) {
		userDAO.save(user);
	}
}