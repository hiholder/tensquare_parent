package com.tensquare.article.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tensquare.article.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
}
