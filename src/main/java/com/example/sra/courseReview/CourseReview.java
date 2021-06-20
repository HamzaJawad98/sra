package com.example.sra.courseReview;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "course_review")
public class CourseReview {
    @Id
    Integer courseReviewId;
    String courseId;
    String review;
    Integer rating;

    public CourseReview(String courseId, String review, Integer rating) {
        this.courseId= courseId;
        this.review = review;
        this.rating = rating;
    }

    public CourseReview() {

    }

    @Column(name = "course_review_id", nullable = false)
    public Integer getCourseReviewId() {
        return courseReviewId;
    }

    public void setCourseReviewId(Integer courseReviewId) { this.courseId = courseId; }

    @Column(name = "course_id", nullable = false)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "review", nullable = true)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Column(name = "rating", nullable = false)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CourseReview{" +
                "courseId=" + courseId +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }
}