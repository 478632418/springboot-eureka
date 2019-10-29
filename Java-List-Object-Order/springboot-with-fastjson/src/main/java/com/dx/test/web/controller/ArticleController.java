package com.dx.test.web.controller;

import com.dx.test.module.Article;
import com.dx.test.module.ArticleType;
import com.dx.test.web.annonations.HeaderTestArgument;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "文章管理", tags = {"文章管理：增、删、改、查"})
@ApiSort(value = 1)
@RestController
@RequestMapping(value = "/api/v1")
public class ArticleController {
    @ApiOperation(value = "根据文章id,查询文章详情", code = 200, httpMethod = "GET", produces = "application/json", notes = "queryById方法定义说明:根据数据库中article表的自增id，查询article信息。")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", paramType = "header", value = "操作用户id", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userName", paramType = "header", value = "操作用户", required = false, dataType = "String"),
            @ApiImplicitParam(name = "id", paramType = "path", value = "文章id", required = true, dataType = "Long")
    })
    @RequestMapping(value = {"/article/{id}"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Article getById(
            @RequestHeader(value = "userId", required = false) String userId,
            @RequestHeader(value = "userName", required = false) String userName,
            @PathVariable(value = "id", required = true) Long id,
            Article article) {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article(1L, "文章1", "", "", new Date()));
        articles.add(new Article(2L, "文章2", "", "", new Date()));
        articles.add(new Article(3L, "文章3", "", "", new Date()));
        articles.add(new Article(4L, "文章4", "", "", new Date()));
        System.out.println(userName);
        return articles.get(0);
    }

    @ApiOperation(value = "查询文章列表", code = 200, httpMethod = "GET", produces = "application/json", notes = "queryById方法定义说明:根据title检索文章，返回文章列表。")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", paramType = "header", value = "操作用户id", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userName", paramType = "header", value = "操作用户", required = false, dataType = "String"),
            @ApiImplicitParam(name = "title", paramType = "query", value = "文章标题检索值", required = false, dataType = "String"),
            @ApiImplicitParam(name = "articleType", paramType = "query", value = "文章类型", required = false, dataType = "ArticleType"),
            @ApiImplicitParam(name = "createTime", paramType = "query", value = "文章发布时间", required = false, dataType = "Date")
    })
    @RequestMapping(value = {"/articles"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Article> queryList(
            @RequestHeader(value = "userId", required = false) String userId,
            @RequestHeader(value = "userName", required = false) String userName,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "articleType",required = false) ArticleType articleType,
            @RequestParam(value = "createTime", required = false) Date createTime) {
        System.out.println(createTime);
        List<Article> articles = new ArrayList<>();
        articles.add(new Article(1L, "文章1", "", "", new Date()));
        articles.add(new Article(2L, "文章2", "", "", new Date()));
        articles.add(new Article(3L, "文章3", "", "", new Date()));
        articles.add(new Article(4L, "文章4", "", "", new Date()));

        return articles.stream().filter(s -> s.getTitle().contains(title)).collect(Collectors.toList());
    }

    @ApiOperation(value = "删除文章", code = 200, httpMethod = "HEAD", produces = "application/json", notes = "queryById方法定义说明:删除文章")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", paramType = "header", value = "操作用户id", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userName", paramType = "header", value = "操作用户", required = false, dataType = "String"),
            @ApiImplicitParam(name = "id", paramType = "header", value = "文章id", required = true, dataType = "Long")
    })
    @RequestMapping(value = {"/article/delete"}, method = {RequestMethod.HEAD}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Integer delete(@RequestHeader(value = "userId", required = false) String userId,
                          @RequestHeader(value = "userName", required = false) String userName,
                          @RequestHeader(value = "id", required = true) Long id) {
        return 1;
    }
}
