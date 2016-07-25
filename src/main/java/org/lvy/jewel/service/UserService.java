package org.lvy.jewel.service;

import org.lvy.jewel.domain.User;
import org.lvy.jewel.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by livvy on 15/6/27.
 */
@Service
public class UserService {


    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
