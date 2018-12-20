package com.jie.dao;

import com.jie.bean.Users;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("usersMapper")
@Scope("prototype")
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByNameAndPwd(Users record);
}