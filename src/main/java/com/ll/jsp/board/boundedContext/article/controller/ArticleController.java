package com.ll.jsp.board.boundedContext.article.controller;


import com.ll.jsp.board.boundedContext.article.dto.Article;
import com.ll.jsp.board.boundedContext.global.base.Rq;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ArticleController {
    private List<Article> articleList;

    public ArticleController() {
        articleList = new ArrayList<>();
        makeTestData();
    }

    void makeTestData() {
        LongStream.rangeClosed(1, 5).forEach(i -> {
            Article article = new Article(i, "제목 " + i, "내용 " + i);
            articleList.add(article);
        });
    }

    public void showList(Rq rq) {
//        Stream
//        List<Article> articleList = this.articleList.stream()
//                .sorted(Comparator.comparing(Article::getId).reversed()) // 정렬 기준 예시
//                .toList();

        Collections.reverse(articleList);
        rq.setAttr("articleList", articleList);
        rq.view("usr/article/list");
    }

}