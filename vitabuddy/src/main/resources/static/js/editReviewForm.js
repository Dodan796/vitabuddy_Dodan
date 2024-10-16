/**
 * 
 */

// 부모 페이지에서 수정 버튼 클릭 시 팝업 창 열기
$(document).ready(function () {
    $('.editButton').on('click', function (event) {
        event.preventDefault(); // 기본 동작 방지

        const supId = $(this).data('sup-id');
        const reviewNo = $(this).data('review-no');

        // 경로 설정하여 팝업 창 열기
        const popupUrl = `/supplement/supplementDetail/${supId}/review/${reviewNo}/editForm`;
        const popup = window.open(
            popupUrl,
            'editReviewPopup',
            'width=1000,height=500,left=100,top=50'
        );

        // 팝업이 정상적으로 열렸는지 확인
        if (!popup || popup.closed || typeof popup.closed === 'undefined') {
            alert("팝업 차단이 감지되었습니다. 브라우저 설정을 확인하세요.");
        }
    });
});









