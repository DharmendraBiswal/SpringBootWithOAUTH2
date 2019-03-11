package com.demo.springbootOAuth2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.springbootOAuth2.dao.UserDao;
import com.demo.springbootOAuth2.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		User user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username or password!");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public User save(User user) {

		return userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(userList::add);

		return userList;
	}

	@Override
	public void delete(long id) {

		userDao.delete(id);

	}

}
