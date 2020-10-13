package com.iiht.eva.interviewtkr.service;

import com.iiht.eva.interviewtkr.dto.UserRepository;
import com.iiht.eva.interviewtkr.entity.User;
import com.iiht.eva.interviewtkr.exception.InvalidData;
import com.iiht.eva.interviewtkr.exception.NotFoundException;
import com.iiht.eva.interviewtkr.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return repository.findById(userId).orElseThrow(() -> new InvalidData("User Id"+userId+" not found in the system"));
    }

    @Override
    @Transactional
    public User addUser(User user) {
        UserValidator userValidator = new UserValidator();
        if (userValidator.validateUser(user)) {
            Optional<User> usr = repository.findById(user.getUserId());
            if (usr.isPresent()) {
                throw new InvalidData(user.getUserId() + " is already exists in the system");
            } else {
                return repository.save(user);
            }
        } else
            throw new InvalidData(userValidator.getErrors());
    }

    @Transactional
    @Override
    public void deleteUser(int userId) {
        repository.deleteById(userId);
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        UserValidator userValidator = new UserValidator();
        if (userValidator.validateUser(user)) {
            repository.findById(user.getUserId()).orElseThrow(() -> new NotFoundException("User", "User Id", user.getUserId()));
            return repository.save(user);
        } else
            throw new InvalidData(userValidator.getErrors());
    }
}
