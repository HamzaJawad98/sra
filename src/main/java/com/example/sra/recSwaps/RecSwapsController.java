package com.example.sra.recSwaps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecSwapsController {
    @Autowired
    private RecSwapsServiceRepo recSwapsServiceRepo;

    @GetMapping("/recswaps")
    public List<RecSwaps> getAllRecSwaps() {
        return recSwapsServiceRepo.findAll();
    }



}