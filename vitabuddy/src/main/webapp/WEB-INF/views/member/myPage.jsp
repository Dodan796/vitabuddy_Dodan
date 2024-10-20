<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <section id="wrap">
        <div class="container">
            <div class="headers">
                    <h1>마이페이지</h1>
            </div>
            <div class="horizontal_box">
                <form>
                    <!-- 복용 중인 영양제 -->
                    <label>복용 중인 영양제</label>
                    <textarea rows="10" cols="100%"readonly>
                        <c:forEach var="supplement" items="${userSupplements}">
                            ${fn:trim(supplement.supName)} - ${fn:trim(supplement.supBrand)}&#13;&#10;
                        </c:forEach>
                    </textarea>
                    <!-- <label>올바른 영양제 복용법</label>
                    <textarea textarea rows="10%" cols="100%"readonly></textarea>    -->
                    <div class="box_rowContents" >
                        <div class="horizontal_box"  readonly;>
                            <label>추천 성분</label>
                            <textarea rows=20%;></textarea>
                        </div>
                        <div class="horizontal_box" readonly>
					   		<label>성분간 상호작용</label>
								<textarea rows="100%" readonly>
								    <c:choose>								        
								        <c:when test="${not empty interactions}">
								            <c:forEach var="interaction" items="${interactions}" varStatus="status">
								                ${status.index + 1}. ${interaction.ingredient1}
								                <c:if test="${interaction.ingredient2 != '해당 없음'}">
								                    - ${interaction.ingredient2}
								                </c:if>
								                &#13;&#10;								                								               
								                <c:if test="${interaction.interactionDetail != '상호작용 정보 없음'}">
								                    ${fn:trim(interaction.interactionDetail)}&#13;&#10;
								                </c:if>
								                 ${fn:trim(interaction.interactionDosage)}&#13;&#10;&#13;&#10;
								            </c:forEach>
								        </c:when>								        								        
								        <c:otherwise>
								            <c:forEach var="interaction" items="${interactions}" varStatus="status">
								                ${status.index + 1}. ${interaction.ingredient1}&#13;&#10;
								                복용 권장 사항: ${fn:trim(interaction.interactionDosage)}&#13;&#10;&#13;&#10;
								            </c:forEach>
								        </c:otherwise>
								    </c:choose>
								</textarea>
						</div>
                    </div>
                </form>
            </div>
            <!-- 예시: sessionScope에서 사용자 ID 가져와서 URL 파라미터로 추가 -->
            <button class="submit-btn" onclick="location.href='/member/myInfoChangeForm?userId=${sessionScope.sid}'">회원 정보 수정하기</button>
            <!-- 내가 작성한 리뷰 목록 -->
                    <div class="review-section">
                        <h3>내가 작성한 리뷰 목록</h3>
                        <form action="/myPage/reviews" method="get">
                            <label for="sort">정렬 기준:</label>
                            <select name="sort" id="sort" onchange="this.form.submit()">
                                <option value="recent">최신순</option>
                                <option value="oldest">오래된 순</option>
                            </select>
                        </form>
                        <table id="reviewList">
                            <thead>
                                <tr>
                                    <th>번호</th>
                                    <th class="important">제목</th>
                                    <th>상품명</th>
                                    <th>작성일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty reviews}">
                                    <c:forEach var="review" items="${reviews}" varStatus="status">
                                        <tr>
                                            <td>${status.index + 1}</td> <!-- 리뷰 번호를 1부터 시작 -->
                                            <td class="important">${review.reviewTitle}</td>
                                            <td>${review.supName}</td> <!-- 상품명을 표시할 컬럼 -->
                                            <td><fmt:formatDate value="${review.reviewDate}" pattern="yyyy-MM-dd" /></td>
                                        </tr>
                                    </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="4" align="center">작성하신 리뷰가 없습니다.</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                    <!-- 구매 내역 -->
                    <div class="purchase-section">
                        <h3>구매 내역</h3>
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
                                <tr>
                                    <th>주문일자</th>
                                    <th>이미지</th>
                                    <th>상품정보</th>
                                    <th>수량</th>
                                    <th>금액</th>
                                    <th>주문 처리</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td colspan="6" align="center">주문 내역이 없습니다.</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
    <c:import url="/WEB-INF/views/layout/footer.jsp"/>
</body>
</html>