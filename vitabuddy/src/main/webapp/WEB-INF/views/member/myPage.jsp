<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/myPage.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/head.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/footer.css'/>">
<c:import url="/WEB-INF/views/layout/head.jsp"/>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<c:import url="/WEB-INF/views/layout/top.jsp" /> 
	<%-- <%@ include file="DYtop.jsp" %> --%><!-- 탑 경로  및 명령어 수정 -->
	<section id="wrap">
		<div class="container">
			<div class="headers">
					<h1>마이페이지</h1>
			</div>
			<div class="horizontal_box" style="width:80%;padding-right:20%; padding-left:20%;">
				<form>
					<label>이름</label>
			        <input type="text" value=" ${getMember.getUserName() }" class="name" name="userName" readonly />
					<!-- 복용 중인 영양제 -->
					<label>복용 중인 영양제</label>
					<textarea rows="10%" cols="100%" style="resize: none; width: 75%;" readonly>
					    <c:forEach var="supplement" items="${userSupplements}">
					        ${supplement.supName} - ${supplement.supBrand}&#13;&#10;
					    </c:forEach>
					</textarea>
					<!-- <label>올바른 영양제 복용법</label>
					<textarea textarea rows="10%" cols="100%"readonly></textarea>	 -->
					<div class="box_rowContents" style="display:flex; justify-content: space-between;padding-right:44%;"> 
						<div class="horizontal_box"  readonly;>	
							<label>추천 성분</label>
							<textarea rows=20%; style="width:250%; resize: none;"></textarea>
						</div>
						<div class="horizontal_box"  readonly; >
							<label>성분간 상호작용</label>
							<textarea rows=20%; style="width:250%; resize: none;"></textarea>
						</div>
					</div>
				
				</form>
			</div>
			<!-- 예시: sessionScope에서 사용자 ID 가져와서 URL 파라미터로 추가 -->
			<button class="submit-btn" onclick="location.href='/member/myInfoChangeForm?userId=${sessionScope.sid}'">회원 정보 수정하기</button>


			<div>
				<div class="review-section" style ="padding-right:20%; padding-left:20%;">
				 	내가 작성한 리뷰 목록
					<select>
						<option>정렬 기준</option>
						<option>최신순</option>
						<option>오래된 순</option>
						<option>조회수 순</option>
						<option>추천 순</option>
						<option>댓글 순</option>
					</select>
					<table id="reviewList">
					<thead>
					<tr>
						<th>번호</th>
						<th class="important" >제목</th>
						<th >작성자</th>
						<th >추천 수</th>
						<th>작성일</th>
					</tr>
					</thead>
						<tbody>
							<tr>
							</tr>
						</tbody>
					</table>
						<div align ="center" class="board" >
							작성하신 리뷰가 없습니다.
						</div>
				</div>
				<div class="purchase-section" style ="padding-right:20%; padding-left:20%;">
					구매 내역
					<select>
						<option>현재 주문 처리 상태</option>
						<option>입금 전</option>
						<option>배송 준비 중</option>
						<option>배송 중</option>
						<option>배송 완료</option>
						<option>취소</option>
						<option>반품</option>
						<option>환불</option>
					</select>
						<table width="100%" id="productInfo">
							<thead>
								<tr >
									<th >주문일자</th>
									<th>이미지</th>
									<th width: 45%;>상품정보</th>
									<th>수량</th>
									<th>금액</th>
									<th>주문 처리</th>
								</tr>
							</thead>
							<tbody>
								<tr>
								</tr>
							</tbody>
						</table>
						<div align ="center" class="board">
							주문 내역이 없습니다.
						</div>
				</div>
			</div>
		</div>
	</section>
	<c:import url="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>