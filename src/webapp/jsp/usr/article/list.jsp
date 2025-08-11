<%@ page import="com.ll.jsp.board.boundedContext.article.dto.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSP 파일에서 JSTL을 사용하기 위해 taglib 선언-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    %>

    <h1>게시물 리스트</h1>

    <div>
        <ul>
            <% for (Article article : articleList) { %>
            <li><%= article.getId() %>번 : <%= article.getTitle() %></li>
            <% } %>
        </ul>

        <ul>
            EL
        <%
        for (int i = articleList.size() - 1; i >= 0; i--) {
        pageContext.setAttribute("article", articleList.get(i));
        %>
        <li>${article.id}번 : ${article.title}</li>
        <% } %>
        </ul>

        <ul>
            JSTL
            <c:forEach var="article" items="${articleList}" varStatus="status">
            <li>${article.id}번 : ${article.title}</li>
            </c:forEach>
        </ul>

        <table border="1">
            <thead>
            <tr>
                <th>번호</th>
                <th>내용</th>
            </tr>
            </thead>
            <c:forEach var="article" items="${articleList}" varStatus="status">
            <tbody>
                <tr>
                    <td>${article.id}번</td>
                    <td>
                        <a href="/usr/article/detail/${article.id}">${article.title}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="/usr/article/write">글쓰기</a>
    </div>