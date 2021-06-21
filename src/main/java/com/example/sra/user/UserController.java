package com.example.sra.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserServiceRepo userServiceRepo;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userServiceRepo.findAll();
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String,String> json)
    {
        try {
        String rollNum = json.get("roll_num");
        String passw = json.get("passw");
        User u = userServiceRepo.authenticate(rollNum, passw);
        if (u != null) {

            String cookie = readCookie("user-id");
            if (cookie == "none") {
                SetCookie(rollNum);
            }
            return u;
        } else
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
    @GetMapping("/read-spring-cookie")
    public String readCookie(@CookieValue(name = "user-id", defaultValue = "none") String userId)
    {
        return userId;
    }
    @PostMapping("/register")
    public String Register(@RequestBody Map<String,String> json)
    {
        try {
            String username = json.get("username");
            String passw = json.get("passw");
            String rollNum = json.get("roll_num");
            String u = userServiceRepo.register(rollNum, username, passw);
            if (u.equals("true")) {
                SetCookie(rollNum);
                return "Success";
            } else
                return null;
        }
        catch (Exception e){
            return null;
        }
    }

    private void SetCookie(String val)
    {
        //Creating a cookie
        ResponseCookie springCookie = ResponseCookie.from("user-id", val)
                .httpOnly(true)
                .path("/")
                .maxAge(3600)
                .build();
        //Appending it to response header
        ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .build();
    }


}
