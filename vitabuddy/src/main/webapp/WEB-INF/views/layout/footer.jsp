<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8"> 
<title>footer</title>
   <link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
</head>
<body>  

<footer>
<div class="footerWrap">
    <div class="inner" align="center">
        <button class="moveTopBtn" type="button" onclick="window.scrollTo(0, 0);">최상단으로</button>
        <div class="moveCS">
            <a href="csCenter.jsp">고객센터</a>
        </div>
    </div>
</div>
</footer>
</body>
</html>
