package com.tensquare.article.repository;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByArticleid(String articleid);


    //根据发布时间和点赞数查询查询

    //根据用户id查询，并且根据发布时间倒序排序
}
