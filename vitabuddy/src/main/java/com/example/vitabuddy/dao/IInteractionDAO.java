package com.example.vitabuddy.dao;

import java.util.List;
import com.example.vitabuddy.model.IngredientVO;
import com.example.vitabuddy.model.InteractionVO;

public interface IInteractionDAO {

    // 1. 사용자의 영양제 목록 조회
    List<Integer> getUserSupplements(String userId);

    // 2. 영양제에 포함된 성분 목록 조회
    List<Integer> getIngredientsBySupId(String userId);

    // 3. 성분 이름 조회
    List<String> getIngredientNames(String userId);

    // 4. 성분 간 상호작용 및 복용 권장 사항 조회
    List<InteractionVO> getInteractionDetails(String userId);
}
