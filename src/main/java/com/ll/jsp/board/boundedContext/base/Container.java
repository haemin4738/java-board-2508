package com.ll.jsp.board.boundedContext.base;

import com.ll.jsp.board.boundedContext.article.controller.ArticleController;
import com.ll.jsp.board.boundedContext.article.repository.ArticleRepository;
import com.ll.jsp.board.boundedContext.article.service.ArticleService;
import com.ll.jsp.board.boundedContext.member.controller.MemberController;
import com.ll.jsp.board.boundedContext.member.repository.MemberRepository;
import com.ll.jsp.board.boundedContext.member.service.MemberService;

public class Container {
    public static MemberController memberController;
    public static ArticleRepository articleRepository;
    public static ArticleService articleService;
    public static ArticleController articleController;
    public static MemberService memberService;
    public static MemberRepository memberRepository;


    static {
        memberRepository = new MemberRepository();
        memberService = new MemberService();
        memberController = new MemberController();
        articleRepository = new ArticleRepository();
        articleService = new ArticleService();
        articleController = new ArticleController();
    }
}