// 검색된 영양제 목록 표시
function searchSupplements() {
    const keyword = document.getElementById('keyword').value;
    const brand = document.getElementById('brand').value;

    $.ajax({
        url: '/supplement/search',
        method: 'GET',
        data: { keyword: keyword, brand: brand },
        success: function(data) {
            displaySupplementList(data);
        },
        error: function() {
            alert('영양제 검색에 실패했습니다.');
        }
    });
}

// 검색 결과를 표시하는 함수
function displaySupplementList(supplements) {
    const supplementList = document.getElementById('supplementList');
    supplementList.innerHTML = ''; 

    supplements.forEach(supplement => {
        const listItem = document.createElement('li');
        listItem.textContent = `${supplement.supName} (${supplement.supBrand})`;

        // 선택 버튼 추가
        const selectButton = document.createElement('button');
        selectButton.textContent = '추가';
        selectButton.onclick = function() {
            addToCurrentList(supplement);
        };

        listItem.appendChild(selectButton);
        supplementList.appendChild(listItem);
    });
}

// 선택된 영양제를 복용 중인 리스트에 추가하고 삭제 버튼 생성
function addToCurrentList(supplement) {
    const currentList = document.getElementById('currentSupplementList');
    const listItem = document.createElement('li');
    listItem.textContent = `${supplement.supName} (${supplement.supBrand})`;
    listItem.setAttribute('data-id', supplement.supID);

    // 삭제 버튼 추가
    const deleteButton = document.createElement('button');
    deleteButton.textContent = '삭제';
    deleteButton.onclick = function() {
        removeFromCurrentList(supplement.supID);
    };

    listItem.appendChild(deleteButton);
    currentList.appendChild(listItem);

    // 서버에 추가 요청 (예시)
    $.ajax({
        url: '/supplement/add', // 실제로는 해당 URL에 맞게 수정
        method: 'POST',
        data: { userId: '현재 사용자 ID', supId: supplement.supID },
        success: function(response) {
            console.log('영양제 추가 성공:', response);
        },
        error: function() {
            alert('영양제 추가에 실패했습니다.');
        }
    });
}

// 복용 중인 리스트에서 삭제
function removeFromCurrentList(supId) {
    const currentList = document.getElementById('currentSupplementList');

    // 서버에 삭제 요청
    $.ajax({
        url: '/supplement/delete',
        method: 'DELETE',
        data: { userId: '현재 사용자 ID', supId: supId },
        success: function(response) {
            alert(response); // 성공 메시지 표시
            // 리스트에서 항목 제거
            const listItem = document.querySelector(`#currentSupplementList li[data-id='${supId}']`);
            if (listItem) {
                listItem.remove();
            }
        },
        error: function() {
            alert('영양제 삭제에 실패했습니다.');
        }
    });
}
