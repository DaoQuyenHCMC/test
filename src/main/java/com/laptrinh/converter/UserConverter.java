package com.laptrinh.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.laptrinh.constant.SystemConstant;
import com.laptrinh.dto.RoleDTO;
import com.laptrinh.dto.User;
import com.laptrinh.entity.RoleEntity;
import com.laptrinh.entity.UserEntity;

@Component
public class UserConverter {

	public User toDto(UserEntity entity) {
		User result = new User();
		result.setId(entity.getId());
		result.setFullName(entity.getFullName());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setStatus(entity.getStatus());
		return result;
	}
	
	public UserEntity toEntity(User dto) {
		UserEntity result = new UserEntity();
		result.setFullName(dto.getFullName());
		result.setPassword(dto.getPassword());
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		result.setUserName(dto.getUserName());
		return result;
	}
	
	
	public List<RoleDTO> toRoleDTO(List<RoleEntity> roles) {
		List<RoleDTO> modelRole = new ArrayList<>();
		for (RoleEntity item : roles) {
			RoleDTO newRole = new RoleDTO();
			newRole.setCode(item.getCode());
			newRole.setName(item.getName());
			modelRole.add(newRole);
		}
		return modelRole;
	}
	
	public List<RoleEntity> toRoleEntity(List<RoleDTO> roles) {
		List<RoleEntity> modelRole = new ArrayList<>();
		for (RoleDTO item : roles) {
			RoleEntity newRole = new RoleEntity();
			newRole.setCode(item.getCode());
			newRole.setName(item.getName());
			modelRole.add(newRole);
		}
		return modelRole;
	}
}
