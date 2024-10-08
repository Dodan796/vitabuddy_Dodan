<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/567f0760c2.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="/jsmember.js"></script>

<c:import url="/WEB-INF/views/layout/head.jsp" />
</head>
<body>
<c:import url="/WEB-INF/views/layout/top.jsp" />
<div id="wrap">
<h2>회원 정보 수정</h2>
<div class="wrapper">
	<form action="memberUpdate.do" method="post" name="frm">
		<tr>
			<td>이름</td>
			</tr>
			<tr>
			 <th><input type="text" name="userName" size="40" value="${GETMEMBER.getUserName() }" /></th>
		</tr><br>
		<tr>
			<td width="35%">아이디</td>
			</tr><tr>
			<td width="65%">${GETMEMBER.getUser_id() }</td>
		</tr><br>
		<tr>
			<td>비밀번호</td>
			</tr><tr>
			<td><input type="password" name="userPwd" size="40" required /></td>
		</tr><br>
		<tr>
			<td>비밀번호 확인</td>
			</tr><tr>
			<td><input type="password" name="confirmPwd" size="40" required /></td>
		</tr><br>
		
		<!--로그인 정보 -->
	
		<tr>
			<td>이메일 변경</td>
			</tr><tr>
			<td><input type="email" name="userEmail" size="40"value="${GETMEMBER.getUserEmail() }"  /></td>
		</tr><br>
	
			<tr>
			<td>전화 번호 변경</td>
			</tr>
			<div>
				<input type="tel" name="userPh1" id="userPh1"placeholder="010"maxlength="3"/>
				-
				<input type="tel" name="userPh2" id="userPh2"placeholder="1111"maxlength="4"/>
				-
				<input type="tel" name="userPh3" id="userPh3"placeholder="1234"maxlength="4"/>
				</div>
		<br>
		<tr>
			<td>우편번호 변경</td>
			</tr><tr>
			<td><input type="text" name="userZipCode" size="40" value="${GETMEMBER.getUserZipCode() }" />
			<button type ="button" name="searchBtn" class="btn">
						우편번호 찾기
					</button></td>
			
		</tr><br>
		<tr>
			<td>주소 변경</td>
			</tr><tr>
			<td><input type="text" name="userAddress1" size="40" value="${GETMEMBER.getUserAdd() }" /></td>
		</tr><br>
		<tr>
			<td>상세 주소 변경</td>
			</tr><tr>
			<td><input type="text" name="userAddress2" size="40" value="${GETMEMBER.getUserAddDetail() }" /></td>
		</tr><br>
		<div>
	<tr>
		<td colspan="2" align="center">
			<input class="button" type="submit" value="회원 정보 수정" />
			
			<input class="button" type="reset" value="다시 쓰기" />
		</td>
	</tr>
</div>
	</form>
	<form class="searchBox" action="" method="get">
		<input class="searchText" type="text" name="" placeholder="영양제 검색">
		<button class="btn" type="submit">
		<i class="fa-solid fa-magnifying-glass"></i>
		</button>	
	</form>
</table>
<table class="table2">
	<form action="memberTabletList.do" method="post" name="frm2">
		<tr>
		<td>복용 중인 영양제 변경</td>
		</tr>
		<tr>
		<td><input type="text" name="userTabletList" size="40" value="${GETMEMBER.getUserTabletList() }" /></td>
		</tr>
	</select>
	
	
	</form>
</table>
</div>
<footer>


</footer>
</body>
</html>