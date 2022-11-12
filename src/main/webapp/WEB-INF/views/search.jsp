<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <title>Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes"/>
    <spring:url value="/resources/css/main.css" var="coreCss" />
    <spring:url value="/resources/favicon.ico" var="favicon" />
    <link rel="icon" type="image/png" href="${favicon}" />
    <link rel="stylesheet" type="text/css" href="${coreCss}" />
</head>

<body>
    <header>
        <h1>Search by year</h1>

        <form method="get">
            <div class="wide-field">
                <label for="year">Minimal year</label>
                <input name="year" id="year" type="number" inputmode="numeric" />
            </div>
            <div class="form-control">
                <button type="submit" class="block form-btn" id="submit">
                    Search
                </button>
                <a href="${pageContext.request.contextPath}/"
                   class="block form-btn" id="back">
                    Back
                </a>
            </div>
        </form>
    </header>

    <main>
        <c:if test="${machines.isEmpty()}">Required items not found</c:if>

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