package com.example.sra.recSwaps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RecSwapsController {
    @Autowired
    private RecSwapsServiceRepo recSwapsServiceRepo;

    @GetMapping("/recswaps")
    public List<RecSwaps> getAllRecSwaps() {
        return recSwapsServiceRepo.findAll();
    }


    @PostMapping("/sendSwapRequest")
    public String sendSwapRequest(@RequestBody Map<String, String> payload)
    {
        try {
            Integer swappingId = Integer.parseInt(payload.get("swappingId"));
            String senderRollNum = payload.get("senderRollNum");
            String answer = recSwapsServiceRepo.sendSwapRequest(swappingId, senderRollNum);
            return "Success";
        }
        catch (Exception e) {
            return null;
        }
    }

}
