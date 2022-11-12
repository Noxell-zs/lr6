<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>Adding</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes"/>
    <spring:url value="/resources/css/main.css" var="coreCss" />
    <spring:url value="/resources/favicon.ico" var="favicon" />
    <link rel="icon" type="image/png" href="${favicon}" />
    <link rel="stylesheet" type="text/css" href="${coreCss}" />
</head>

<body>
    <header>
        <h1>Adding a coffee machine</h1>
    </header>

    <main>
        <form method="post">
            <div class="wide-field">
                <label for="name">Name</label>
                <input name="name" id="name"
                       <c:if test="${v.invalid()}">value="${m.getName()}"</c:if>/>
                <c:if test="${v.invalidName()}">
                    <span class="error-field">ERROR: a non-empty string is required</span>
                </c:if>
            </div>

            <div class="wide-field">
                <label for="country">Country of manufacture</label>
                <input name="country" id="country"
                       <c:if test="${v.invalid()}">value="${m.getCountry()}"</c:if>/>
            </div>

            <div class="wide-field">
                <label for="year">Year of manufacture</label>
                <input name="year" id="year" type="number" inputmode="numeric"
                       <c:if test="${v.invalid()}">value="${m.getYear()}"</c:if>/>
                <c:if test="${v.invalidYear()}">
                    <span class="error-field">ERROR: a number from 1800 to 2022 is required</span>
                </c:if>
            </div>

            <div class="wide-field">
                <label for="reservoir">Volume of reservoir (in grams)</label>
                <input name="reservoir" id="reservoir" type="number" inputmode="numeric"
                       <c:if test="${v.invalid()}">value="${m.getReservoir()}"</c:if>/>
            </div>

            <div class="wide-field">
                <label for="description">Description</label>
                <textarea name="description" id="description" rows="3"
                ><c:if test="${v.invalid()}">${m.getDescription()}</c:if></textarea>
            </div>


            <div class="form-control">
                <button type="submit" class="block form-btn" id="submit">
                    Submit
                </button>
                <a href="${pageContext.request.contextPath}/"
                   class="block form-btn" id="back">
                    Back
                </a>
            </div>
        </form>
    </main>
</body>
</html>