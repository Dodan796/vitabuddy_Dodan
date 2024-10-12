package com.example.vitabuddy.controller;

import com.example.vitabuddy.model.SupplementDetailVO;
import com.example.vitabuddy.service.SupplementDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/supplement")
public class SupplementDetailController {
    @Autowired
    private SupplementDetailService supplementDetailService;

    @GetMapping("/supplementDetail/{id}")
    public String getSupplementDetailPage(@PathVariable("id") int supplementDetailId, Model model) {
        SupplementDetailVO detail = supplementDetailService.getSupplementDetailById(supplementDetailId);
        model.addAttribute("sup", detail);
        return "supplement/supplementDetail"; // JSP 파일 반환
    }
}
