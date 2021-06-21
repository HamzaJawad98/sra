package com.example.sra.courseReview;

import com.example.sra.teacherReview.TeacherReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CourseReviewController {
    @Autowired
    private CourseReviewServiceRepo courseReviewServiceRepo;


    @GetMapping("/coursereview")
    public List<CourseReview> getAllCourses() {
        return courseReviewServiceRepo.findAll();
    }


    @PostMapping("/addCourseReview")
    public String addCourseReview(@RequestBody Map<String,String> payload)
    {
        try {
            String courseId = payload.get("courseId");
            String review = payload.get("review");
            Integer rating = Integer.parseInt(payload.get("rating"));
            courseReviewServiceRepo.addCourseReview(courseId, review, rating);
            return "Success";
        }
        catch (Exception e)
        {
            return "Failure";
        }
    }

    @GetMapping("/getCourseReviews")
    public List<CourseReview> getCourseReviews(@RequestParam String courseId)
    {
        try {
            List<CourseReview> courseReviews = courseReviewServiceRepo.getCourseReviews(courseId);
            return courseReviews;
        }
        catch (Exception e){
            return null;
        }
    }

}
