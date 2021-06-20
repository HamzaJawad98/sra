package com.example.sra.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping(path="/User")

@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    @Autowired
    private TeacherServiceRepo teacherServiceRepo;

    @GetMapping("/teacher")
    public List<Teacher> getAllTeachers() {
        return teacherServiceRepo.findAll();
    }

}