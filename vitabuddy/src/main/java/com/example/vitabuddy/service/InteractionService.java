package com.example.vitabuddy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.vitabuddy.dao.IInteractionDAO;
import com.example.vitabuddy.model.IngredientVO;
import com.example.vitabuddy.model.InteractionVO;

@Service
public class InteractionService implements IInteratcionService {

    @Autowired
    IInteractionDAO dao;

    @Override
    public List<Integer> getUserSupplements(String userId) {
        return dao.getUserSupplements(userId);
    }

    @Override
    public List<Integer> getIngredientsBySupId(String userId) {
        return dao.getIngredientsBySupId(userId);
    }

    @Override
    public List<String> getIngredientNames(String userId) {
        return dao.getIngredientNames(userId);
    }

    @Override
    public List<InteractionVO> getInteractionDetails(String userId) {
        return dao.getInteractionDetails(userId);
    }
}
