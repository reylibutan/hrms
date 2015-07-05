package com.reylibutan.tabularasa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reylibutan.tabularasa.dto.PersonDTO;
import com.reylibutan.tabularasa.dto.UserDTO;
import com.reylibutan.tabularasa.entity.Person;
import com.reylibutan.tabularasa.entity.User;

@Mapper(componentModel = "spring")
public interface GeneralMapper {
	
	User userDtoToUser(UserDTO userDto);
	
	PersonDTO personToPersonDto(Person person);
	
	List<PersonDTO> personsToPersonDtos(List<Person> personList);
}