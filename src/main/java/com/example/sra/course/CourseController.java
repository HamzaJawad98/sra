package com.example.sra.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping(path="/User")

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    @Autowired
    private CourseServiceRepo courseServiceRepo;

    @GetMapping("/getAllCourses")
    public List<Course> _getAllCourses() {
        return courseServiceRepo.findAll();
    }

    @GetMapping("/getAllCourseNames")
    public List<Course> getAllCourseNames() {
        try{
            return courseServiceRepo.findAll();
        }
        catch (Exception e){
            return null;
        }
    }
}
