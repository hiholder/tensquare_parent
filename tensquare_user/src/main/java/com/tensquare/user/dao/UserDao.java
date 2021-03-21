package com.tensquare.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tensquare.user.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {

}

