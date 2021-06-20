package com.example.sra.course;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "course")
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private Integer batch;

    public Course(String courseId, String courseName, Integer batch) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.batch = batch;
    }

    public Course() {
    }

    @Column(name = "course_id", nullable = false)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "course_name", nullable = false)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "batch", nullable = false)
    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", batch=" + batch +
                '}';
    }
}
