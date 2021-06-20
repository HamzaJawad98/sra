package com.example.sra.teacherReview;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "teacher_review")
public class TeacherReview {
    @Id
    Integer tReviewId;
    String tName;
    String review;
    Integer rating;

    public TeacherReview(String tName, String review, Integer rating) {
        this.tName = tName;
        this.review = review;
        this.rating = rating;
    }

    public TeacherReview() {

    }
    @Column(name = "t_review_id", nullable = false)
    public Integer gettReviewId() {
        return tReviewId;
    }

    public void settReviewId(Integer tReviewId) {
        this.tReviewId = tReviewId;
    }


    @Column(name = "t_name", nullable = false)
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
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
        return "TeacherReview{" +
                "tName='" + tName + '\'' +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }
}