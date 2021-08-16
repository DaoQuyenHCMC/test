package com.laptrinh.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinh.dto.UserDTO;

public class SecurityUtils {
	public static UserDTO getPrincipal() {
		UserDTO userDTO = (UserDTO) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		return userDTO;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities(){
		List<String> result = new ArrayList<String>();
		List<GrantedAuthority> authorities= (List<GrantedAuthority>)(SecurityContextHolder.getContext()).getAuthentication().getAuthorities();
		for (GrantedAuthority authority: authorities) {
			result.add(authority.getAuthority());
		}
		return result;
	}
}
