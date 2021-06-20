package com.example.sra.teacherReview;

import com.example.sra.swapping.Swapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherReviewServiceRepo extends JpaRepository<TeacherReview, String>{
    @Query(value="select t_name from teacher", nativeQuery = true)
    List<String> getAllTeacherNames();

    @Query(value = "insert into teacher_review OUTPUT 'true' " +
            "values(:tName, :review, :rating)", nativeQuery = true)
    String addTeacherReview(@Param("tName") String tName, @Param("review") String review, @Param("rating") Integer rating);

    @Query(value="select * from teacher_review where t_name = :tName", nativeQuery = true)
    List<TeacherReview> getTeacherReviews(@Param("tName") String tName);
}
