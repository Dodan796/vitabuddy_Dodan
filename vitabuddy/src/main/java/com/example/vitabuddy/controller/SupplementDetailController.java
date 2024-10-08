package com.example.vitabuddy.controller;

import com.example.vitabuddy.model.SupplementDetailVO;
import com.example.vitabuddy.service.SupplementDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class SupplementDetailController {

    @Autowired
    private SupplementDetailService supplementDetailService;

    @GetMapping("/{id}")
    public SupplementDetailVO getSupplementDetail(@PathVariable("id") int supplementDetailId) {
        return supplementDetailService.getSupplementDetailById(supplementDetailId);
    }
}
