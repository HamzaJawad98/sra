package com.example.sra.timetable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "timetable")
public class Timetable{
    @Id
    String courseId;
    Integer timeId;
    String section;
    String venue;

    public Timetable(String courseId, Integer timeId, String section, String venue) {
        this.courseId = courseId;
        this.timeId = timeId;
        this.section = section;
        this.venue = venue;
    }

    public Timetable(){

    }

    @Column(name = "course_id", nullable = false)
    public String getcourseId() {
        return courseId;
    }

    public void setcourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "time_id", nullable = false)
    public Integer gettimeId() {
        return timeId;
    }

    public void settimeId(Integer timeId) {
        this.timeId = timeId;
    }

    @Column(name = "section", nullable = false)
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Column(name = "venue", nullable = false)
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "courseId='" + courseId + '\'' +
                ", timeId=" + timeId +
                ", section='" + section + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}