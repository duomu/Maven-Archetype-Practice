package it.pkg.basic.service.impl;

import it.pkg.basic.mapper.UserMapper;
import it.pkg.basic.model.User;
import it.pkg.basic.model.UserExample;
import it.pkg.basic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：linlin.yang
 * Date：2017/6/29 16:00
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public int getUserCount() {
        UserExample userExample=new UserExample();
        userExample.createCriteria();
        return userMapper.countByExample(userExample);
    }

    public List<User> getUserByName(String name) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        return (List<User>) userMapper.selectByExample(userExample);
    }
}
