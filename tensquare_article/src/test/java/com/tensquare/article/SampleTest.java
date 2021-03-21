package com.tensquare.article;

import com.tensquare.article.dao.UserMapper;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.pojo.User;
import com.tensquare.article.service.ArticleService;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SampleTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testSelect() {
        System.out.println("----- selectAll method test ------");
        List<Article> articleList = articleService.findAll();
        for (Article article:articleList){
            System.out.println(article);
        }
        //List<User> userList = userMapper.selectList(null);

    }
}
