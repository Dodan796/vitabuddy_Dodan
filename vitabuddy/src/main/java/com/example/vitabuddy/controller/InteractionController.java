package com.example.vitabuddy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vitabuddy.model.InteractionVO;
import com.example.vitabuddy.service.InteractionService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class InteractionController {
  

    @GetMapping("/myPage/interaction")
    public String getUserSupplements(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("sid");
        System.out.println("UserID: " + userId);
        // 성분 이름 및 상호작용 정보 가져오기
       

        return "member/myPage"; 
    }
}
