package com.jie.service.impl;

import com.jie.bean.Users;
import com.jie.dao.UsersMapper;
import com.jie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qiangzi
 * @create 2018--12--21 5:25
 */
@Service("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("usersMapper")
    private UsersMapper um;
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Users login(Users u){
           Users u1=um.selectByNameAndPwd(u);
           System.out.println(u1.getUsername());
           return u1;
    }
}
