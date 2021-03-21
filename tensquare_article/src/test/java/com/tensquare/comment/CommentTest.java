package com.tensquare.comment;



import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CommentTest {
    CommentService commentService=new CommentService();
    @Test
    public void myTest(){
        System.out.println(commentService);
        Comment comment=commentService.findById("1");
        System.out.println(comment);
    }

}
