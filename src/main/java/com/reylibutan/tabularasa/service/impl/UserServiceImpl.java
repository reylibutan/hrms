package com.reylibutan.tabularasa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reylibutan.tabularasa.entity.User;
import com.reylibutan.tabularasa.repository.UserRepository;
import com.reylibutan.tabularasa.service.UserService;
import com.reylibutan.tabularasa.utility.StringUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDAO;
	
	@Override
	public void save(User user) {
		String hashedPassword = StringUtil.hashString(user.getPassword()); 
		
		user.setPassword(hashedPassword);
		user.setConfirmPassword(hashedPassword); // set to pass @FieldMatches validator
		
		userDAO.save(user);
	}
}