package com.ll.jsp.board.boundedContext.article.repository;

import com.ll.jsp.board.boundedContext.article.dto.Article;
import com.ll.jsp.board.boundedContext.base.Container;
import com.ll.jsp.board.db.DBConnection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;

public class ArticleRepository {
    private List<Article> articleList;
    private DBConnection dbConnection;

    public ArticleRepository() {
        articleList = new ArrayList<>();
        makeTestData();

        dbConnection = Container.dbConnection;

    }

    void makeTestData() {
        LongStream.rangeClosed(1, 5).forEach(i -> {
            Article article = new Article(i, "제목 " + i, "내용 " + i);
            articleList.add(article);
        });
    }

    public List<Article> findAll() {


        return articleList.stream()
                .sorted(Comparator.comparing(Article::getId).reversed()) // 정렬 기준 예시
                .toList();
    }

    public long save(String title, String content) {
        int id = dbConnection.insert("INSERT INTO article SET title = '%s', content = '%s'".formatted(title, content));

        return id;
    }

    public Article findById(long id) {
        return articleList.stream()
                .filter(article -> article.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void modify(long id, String title, String content) {
        Article article = findById(id);

        if (article == null) return;

        article.setTitle(title);
        article.setContent(content);
    }

    public void delete(long id) {
        Article article = findById(id);

        if (article == null) return;

        articleList.remove(article);
    }
}