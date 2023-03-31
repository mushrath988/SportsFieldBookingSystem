package com.te.sbs.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.sbs.dto.UserDto;
import com.te.sbs.entity.User;
import com.te.sbs.exception.RegistrationException;
import com.te.sbs.exception.UserNotFoundException;
import com.te.sbs.repository.UserRepository;
import com.te.sbs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDto register(UserDto userDto) {
		try {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			userRepository.save(user);
			return userDto;
		} catch (Exception ex) {
			throw new RegistrationException("Error occured while registering user", ex);
		}
	}

	@Override
	public User findByEmail(UserDto userDto) {
			User user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(()->
			new UserNotFoundException("Email not found", userDto.getEmail(), null));
			if (user != null && userDto.getEmail().equals(user.getEmail()))
				;
			return user;			
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> user = userRepository.findAll();
		List<UserDto> userDto = new ArrayList<>();
		user.forEach(e -> {
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(e, dto);
			userDto.add(dto);
		});
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(()->
		new UserNotFoundException("User id is not present",null, id));
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	@Override
	public Integer deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(()-> new
				UserNotFoundException("User id is not present", null, id));
		userRepository.deleteById(id);
		return user.getUserId();
	}

}
