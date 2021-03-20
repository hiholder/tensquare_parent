package com.tensquare.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;
import org.springframework.stereotype.Component;

@Component
public interface ArticleDao extends BaseMapper<Article> {
}
