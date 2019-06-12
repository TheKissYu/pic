package com.yuhaoze.dao;

import com.yuhaoze.entity.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

    UserLogin UserLoginMapper(String loginName);


}