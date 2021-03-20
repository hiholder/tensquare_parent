package com.tensquare.article.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
//import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("tb_article")//表名注解
@Data
public class Article implements Serializable {
    //主键注解，INPUT表示insert前自行set主键值
    @TableId(type = IdType.INPUT)//
    private String id;    //
    private String columnid;//专栏id
    private String userid;//用户id
    private String title;//标题
    private String content;//正文内容
    private String image;//文字封面
    private Date createtime;//发表时间
    private Date updatetime;//修改时间
    private String ispublic;//是否公开
    private String istop;//是否置顶
    private Integer visits;//观看数
    private Integer thumbup;//点赞数
    private Integer comment;//评论数
    private String state;//状态
    private String channelid;//所属频道
    private String url;//url
    private String type;//类型

    public Article(String id, String userid, String title) {
        this.id = id;
        this.userid = userid;
        this.title = title;

    }

}
