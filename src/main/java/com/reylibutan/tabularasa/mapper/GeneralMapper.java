package com.reylibutan.tabularasa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.reylibutan.tabularasa.dto.UserDTO;
import com.reylibutan.tabularasa.entity.User;

@Mapper
public interface GeneralMapper {
	
	GeneralMapper INSTANCE = Mappers.getMapper(GeneralMapper.class);
	
	User userDtoToUser(UserDTO userDto);
}