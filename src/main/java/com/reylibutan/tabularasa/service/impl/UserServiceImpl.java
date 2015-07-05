package com.reylibutan.tabularasa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reylibutan.tabularasa.dto.UserDTO;
import com.reylibutan.tabularasa.entity.User;
import com.reylibutan.tabularasa.mapper.GeneralMapper;
import com.reylibutan.tabularasa.repository.UserRepository;
import com.reylibutan.tabularasa.service.UserService;
import com.reylibutan.tabularasa.utility.StringUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void save(UserDTO userDto) {
		User user = GeneralMapper.INSTANCE.userDtoToUser(userDto);
		String hashedPassword = StringUtil.hashString(userDto.getPassword());
			
		user.setPassword(hashedPassword);
		userRepo.save(user);
	}
}