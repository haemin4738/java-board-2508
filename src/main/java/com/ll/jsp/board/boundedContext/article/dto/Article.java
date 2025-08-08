package com.ll.jsp.board.boundedContext.article.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Article {
    private long id;
    private String title;
    private String content;

    public Article(long id, String title, String content) {
        this.id = id; // 기본값 설정
        this.title = title;
        this.content = content;
    }
}