package com.ll.jsp.board.boundedContext.article.service;

import com.ll.jsp.board.boundedContext.article.dto.Article;
import com.ll.jsp.board.boundedContext.article.repository.ArticleRepository;
import com.ll.jsp.board.boundedContext.base.Container;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = Container.articleRepository;

    }
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public long write(String title, String content) {
        return articleRepository.save(title, content);
    }
}
