package com.te.sbs.service;

import java.util.List;
import com.te.sbs.dto.UserDto;
import com.te.sbs.entity.User;

public interface UserService {

	UserDto register(UserDto userDto);

	User findByEmail(UserDto userDto);

	UserDto getUserById(Integer id);

	Integer deleteUser(Integer id);

	List<UserDto> getAllUsers();


}
