<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/567f0760c2.js" crossorigin="anonymous"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <title>비타버디 가입하기</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
    <script src="/js/register.js"></script> <!-- JS 파일을 추가 -->
</head>
<body>
<c:import url="/WEB-INF/views/layout/top.jsp" /> 
<c:import url="/WEB-INF/views/layout/head.jsp" /> 
	<div id="wrap">
		<div class="container">
			<h1>회원 가입</h1>
			<form onsubmit="return false;">
				<div class="left">
					<label>이름</label>
					<input type="text" name="userName" id="userName" required/>
					<br>아이디
					<button type="button" onclick="fnDbCheckId()" name="dbCheckId" class="btn">
						중복확인
					</button>
					<input type="text" name="userId" id="userId" required/>
				
					<label>비밀번호 설정</label>
					<input type="password" name="userPwd" id="userPwd" oninput="pwCheck()" required/>
					<br><span id="pwLeng"></span>
					<label>비밀번호 확인</label>
					<input type="password" name="confirmPwd" id="confirmPwd" oninput="pwCheck()" required/><br>
					<span id="pwOk"></span>
					<div class="phone-number">
						<label>전화 번호 입력</label>
						<input type="tel" name="userPh1" id="userPh1" placeholder="010" maxlength="3" required/>
						-
						<input type="tel" name="userPh2" id="userPh2" placeholder="1111" maxlength="4" required/>
						-
						<input type="tel" name="userPh3" id="userPh3" placeholder="1234" maxlength="4" required/>
					</div>
					<label>이메일</label>
					<input type="email" name="userEmail" id="userEmail" onchange="emailCheck()" required/>
					<br><span id="emOk"></span>
				</div>
			
				<div class="right">
					<div class="zipcode">
						우편번호 입력<button type="button" name="searchBtn" class="btn" onclick="openZipSearch()">우편번호 찾기</button><br>
						<input type="text" name="userZipcode" id="userZipcode" readonly/>		
						<label>주소 입력</label>
						<input type="text" name="userAddress1" id="userAddress1" readonly/>
						<label>상세 주소 입력</label>
						<input type="text" name="userAddress2" id="userAddress2" required/>
					</div>
				</div>
			</form>
			<button class="submit-btn" type="button" id="submitBtn" onclick="registerMember()">회원가입</button>
		</div>
	</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />  
</body>
</html>
