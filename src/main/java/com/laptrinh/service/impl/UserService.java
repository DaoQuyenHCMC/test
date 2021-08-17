package com.laptrinh.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinh.converter.UserConverter;
import com.laptrinh.dto.RoleDTO;
import com.laptrinh.dto.User;
import com.laptrinh.entity.RoleEntity;
import com.laptrinh.entity.UserEntity;
import com.laptrinh.repository.UserRepository;
import com.laptrinh.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public List<User> findAll(Pageable pageable) {
		List<User> models = new ArrayList<>();

		List<UserEntity> entities = userRepository.findAll(pageable).getContent();

		for (UserEntity item : entities) {
			User newUser = new User();
			newUser.setUserName(item.getUserName());
			newUser.setStatus(item.getStatus());
			newUser.setFullName(item.getFullName());
			newUser.setRoles(userConverter.toRoleDTO(item.getRoles()));
			models.add(newUser);
		}
		return models;
	}



	@Override
	public int getToTalItem() {
		// TODO Auto-generated method stub
		return (int) userRepository.count();
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User save(User dto) {
		UserEntity userEntity= new UserEntity();
		if( dto!= null && dto.getUserName()!=null) {
			userEntity = userRepository.findOneByUserName(dto.getUserName());
		}
		if (userEntity != null) {
			userEntity.setFullName(dto.getFullName());
			userEntity.setPassword(dto.getPassword());
			userEntity.setStatus(dto.getStatus());
			userEntity.setRoles(userConverter.toRoleEntity(dto.getRoles()));
		}else {
			
			userEntity=userConverter.toEntity(dto);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id: ids) {
			userRepository.delete(id);
		}
	}



}
