<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Add New Student</h1>
        <c:if test="${param.error != null}">
            <p class="error-msg">Error: ${param.error}</p>
        </c:if>
        <form:form action="/saveStudent" method="post" modelAttribute="student">
            <label>Name:</label>
            <form:input path="name" required="required" />
            
            <label>Email:</label>
            <form:input path="email" type="email" required="required" />
            
            <label>Course:</label>
            <form:select path="course.id" required="required">
                <form:option value="" label="-- Select Course --"/>
                <form:options items="${courses}" itemValue="id" itemLabel="name" />
            </form:select>
            
            <div style="text-align: center; margin-top: 20px;">
                <button type="submit" class="btn btn-primary">Save Student</button>
                <a href="/" class="btn btn-warning">Cancel</a>
            </div>
        </form:form>
    </div>
</body>
</html>
