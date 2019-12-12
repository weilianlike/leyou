package com.leyou.user.service;

import com.leyou.user.mapper.UserMapper;
import com.leyou.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Boolean checkData(String data, Integer type) {
        User record = new User();
        switch (type) {
            case 1:         //如果type等于1
                record.setUsername(data);//设置用户名
                break;
            case 2://如果type等于2
                record.setPhone(data);//设置密码
                break;
            default:
                return null;//参数不合法
        }
        return this.userMapper.selectCount(record) == 0;
    }
}