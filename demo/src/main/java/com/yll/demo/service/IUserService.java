package com.yll.demo.service;

import com.yll.demo.model.User;

import java.util.List;

/**
 * Author：linlin.yang
 * Date：2017/6/29 15:59
 */
public interface IUserService {
    int getUserCount();

    List<User> getUserByName(String name);
}
