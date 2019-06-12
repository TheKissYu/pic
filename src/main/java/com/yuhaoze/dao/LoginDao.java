package com.yuhaoze.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhaoze.entity.Login;

public interface LoginDao extends BaseMapper<Login> {
    String getName();
}
