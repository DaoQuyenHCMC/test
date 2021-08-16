package com.laptrinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinh.constant.SystemConstant;
import com.laptrinh.dto.UserDTO;
import com.laptrinh.entity.RoleEntity;
import com.laptrinh.entity.UserEntity;
import com.laptrinh.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity= userRespository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity==null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		
		for(RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		// put thong tin user de duy tri khi user login vao he thong
		UserDTO userDTO= new UserDTO(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		userDTO.setFullName(userEntity.getFullName());
		return userDTO;
	}

}
