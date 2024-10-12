/**
 * 
 */
 $(document).ready(function () {
    $.ajax({
        url: '/reviews/all',
        type: 'GET',
        success: function (data) {
            // 리뷰 데이터를 처리하는 로직을 작성
            console.log(data); // data에 전체 리뷰가 담김
        },
        error: function (xhr, status, error) {
            alert('리뷰 목록을 불러오는 중 오류가 발생했습니다.');
        }
    });
});
 