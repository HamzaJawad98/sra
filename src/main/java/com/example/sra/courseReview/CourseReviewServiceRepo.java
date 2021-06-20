package com.example.sra.courseReview;

import com.example.sra.teacherReview.TeacherReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseReviewServiceRepo extends JpaRepository<CourseReview, String>{
    @Query(value="select course_id from course_review", nativeQuery = true)
    List<String> getAllCourseIds();

    @Query(value="select course_name from course where course_id = :courseId", nativeQuery = true)
    String getCourseName(@Param("courseId") String courseId);

    @Query(value = "insert into course_review OUTPUT 'true' " +
            "values(:courseId, :review, :rating)", nativeQuery = true)
    String addCourseReview(@Param("courseId") String courseId, @Param("review") String review, @Param("rating") Integer rating);

    @Query(value="select * from course_review where course_id = :courseId", nativeQuery = true)
    List<CourseReview> getCourseReviews(@Param("courseId") String courseId);
}
