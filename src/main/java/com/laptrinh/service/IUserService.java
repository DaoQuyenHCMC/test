package com.laptrinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinh.dto.User;

public interface IUserService {
	List<User> findAll(Pageable pageable);
	int getToTalItem();
	User findByUserName(String userName);
	User save(User dto);
	void delete(long[] ids);
}
