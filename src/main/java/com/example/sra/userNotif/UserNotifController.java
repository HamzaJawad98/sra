package com.example.sra.userNotif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserNotifController {
    @Autowired
    private UserNotifServiceRepo userNotifServiceRepo;

    @GetMapping("/usernotif")
    public List<UserNotif> getAllUserNotifs() {
        return userNotifServiceRepo.findAll();
    }



}
