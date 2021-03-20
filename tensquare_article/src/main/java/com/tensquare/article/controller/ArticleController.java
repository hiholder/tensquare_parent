package com.tensquare.article.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    // DELETE /article/{articleId} 根据ID删除文章
    @RequestMapping(value = "{articleId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String articleId) {
        articleService.deleteById(articleId);

        return new Result(true, StatusCode.OK, "删除成功");
    }


    // PUT /article/{articleId} 修改文章
    @RequestMapping(value = "{articleId}", method = RequestMethod.PUT)
    public Result updateById(@PathVariable String articleId,
                             @RequestBody Article article) {
        //设置id
        article.setId(articleId);
        // 执行修改
        articleService.updateById(article);

        return new Result(true, StatusCode.OK, "修改成功");
    }

    // POST /article 增加文章
    //@RequestBody可以将json数据转化为java对象
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleService.save(article);
        return new Result(true, StatusCode.OK, "新增成功");
    }


    // GET /article/{articleId} 根据ID查询文章
    @RequestMapping(value = "{articleId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String articleId) {
        Article article = articleService.findById(articleId);
        return new Result(true, StatusCode.OK, "查询成功", article);
    }

    // GET /article 文章全部列表
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result search(@RequestBody Map map, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        //之前接收文件数据使用pojo，现在根据条件查询
        //而所有条件都需要进行判断,遍历pojo的所有属性要使用反射，性能开销较大
        //直接使用集合的方式，这里以Map形式接收数据
        IPage page1 = articleService.findByPage(map, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult(page1.getTotal(), page1.getRecords()));

    }
   /* @RequestMapping(value = "/exception",method = RequestMethod.GET)
    public Result exception() throws Exception {
        throw new Exception("测试统一异常处理");
    }*/
    //测试公共异常处理
   /* @RequestMapping(value = "exception", method = RequestMethod.GET)
    public Result test() {
        int a = 1 / 0;

        return null;
    }*/
}

