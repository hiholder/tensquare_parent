package com.tensquare.article.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public List<Article> findAll() {
        Article article = articleDao.selectById(1);
        return articleDao.selectList(null);
    }

    public Article findById(String articleId) {
        return articleDao.selectById(articleId);
    }

    public void save(Article article) {
        //使用分布式id生成器
        String id = idWorker.nextId() + "";
        article.setId(id);

        //初始化数据
        article.setVisits(0);   //浏览量
        article.setThumbup(0);  //点赞数
        article.setComment(0);  //评论数

        //新增
        articleDao.insert(article);
    }

    public void updateById(Article article) {
        // 根据主键id修改
        articleDao.updateById(article);

        // 根据条件修改
        // 创建条件对象
        // EntityWrapper<Article> wrapper = new EntityWrapper<>();
        // 设置条件
        // wrapper.eq("id", article.getId());
        // articleDao.update(article, wrapper);
    }

    public void deleteById(String articleId) {
        articleDao.deleteById(articleId);
    }

    public IPage<Article> findByPage(Map<String, Object> map, Integer page, Integer size) {
        //设置查询条件
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            wrapper.eq(map.get(key) != null, key, map.get(key));
        }
        //wrapper.allEq(map);
        //设置分页参数
        //设置分页参数
        IPage<Article> pageData = new Page<>(page, size, true);

        //执行查询
        //第一个是分页参数，第二个是查询条件
        //List<Article> list = (List<Article>) articleDao.selectPage(pageData, wrapper);


        pageData = articleDao.selectPage(pageData, wrapper);
        System.out.println(pageData.getTotal());
        //pageData.setRecords((List<Article>) list);
        //pageData.setRecords(articleDao.selectPage(pageData,  wrapper));

        //返回
        return pageData;
    }

}
