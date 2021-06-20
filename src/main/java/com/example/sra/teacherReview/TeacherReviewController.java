package com.example.sra.teacherReview;

import com.example.sra.teacher.TeacherServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TeacherReviewController {
    @Autowired
    private TeacherReviewServiceRepo teacherReviewServiceRepo;

    @GetMapping("/teacherreview")
    public List<TeacherReview> getAllTeachers() {
        return teacherReviewServiceRepo.findAll();
    }

    @GetMapping("/getAllTeacherNames")
    public List<String> getAllTeacherNames() {
        return teacherReviewServiceRepo.getAllTeacherNames();
    }

    @PostMapping("/addTeacherReview")
    public String addTeacherReview(@RequestBody Map<String, String> payload)
    {
        try {
            String tName = payload.get("tName");
            String review = payload.get("review");
            Integer rating = Integer.parseInt(payload.get("rating"));
            teacherReviewServiceRepo.addTeacherReview(tName, review, rating);
            return "Success";
        }
        catch (DataAccessException e)
        {
            return "Failure";
        }
    }

    @GetMapping("/getTeacherReviews")
    public List<TeacherReview> getTeacherReviews(@RequestParam String tName)
    {
        List<TeacherReview> teacherReviews = teacherReviewServiceRepo.getTeacherReviews(tName);
        return teacherReviews;
    }

}
