package com.reylibutan.tabularasa.mapper;

import org.mapstruct.Mapper;

import com.reylibutan.tabularasa.dto.UserDTO;
import com.reylibutan.tabularasa.entity.User;

@Mapper(componentModel = "spring")
public interface GeneralMapper {
	
	User userDtoToUser(UserDTO userDto);
}