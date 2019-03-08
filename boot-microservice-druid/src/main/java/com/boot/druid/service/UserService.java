package com.boot.druid.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.druid.dao.UserDao;
import com.boot.druid.pojo.User;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User> {

    public List<User> findUserList(User user) {
        return dao.findUserList(user);
    }

    public User getUserByName(String username) {
        return dao.getByUsername(username);
    }
}