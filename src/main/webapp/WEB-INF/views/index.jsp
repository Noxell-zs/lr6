<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <title>Coffee machine database</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes"/>
    <spring:url value="/resources/css/main.css" var="coreCss" />
    <spring:url value="/resources/favicon.ico" var="favicon" />
    <link rel="icon" type="image/png" href="${favicon}" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<body>

    <header>
        <h1>Welcome to the coffee machine database</h1>
        <div class="container">
            <a class="block" id="add"
               href="${pageContext.request.contextPath}/add">
                Add a coffee machine
            </a>
            <a class="block" id="search"
               href="${pageContext.request.contextPath}/search">
                Search by year
            </a>
        </div>
    </header>

    <main>
        <c:forEach items="${machines}" var="machine">
            <div class="item block">
                <p class="description">${machine.toString()}</p>
                <p class="container">
                    <a class="edit"
                       href="${pageContext.request.contextPath}/edit/${machine.id}">
                        Edit
                    </a>
                    <a class="del"
                       href="${pageContext.request.contextPath}/del/${machine.id}">
                        Delete
                    </a>
                </p>
            </div>
        </c:forEach>
    </main>
</body>
</html>