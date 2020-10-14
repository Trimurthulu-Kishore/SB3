package com.iiht.eva.interviewtkr.service;

import java.util.List;

import com.iiht.eva.interviewtkr.entity.User;
import com.iiht.eva.interviewtkr.exception.NotFoundException;

public interface UserService {
	 List<User> getAllUsers();
	    User getUserById(int userId) throws NotFoundException;
	    User addUser(User user);
	    void deleteUser(int userId);
	    User saveUser(User user) throws NotFoundException;
}
