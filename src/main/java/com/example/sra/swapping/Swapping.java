package com.example.sra.swapping;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "swapping")
public class Swapping {
    @Id
    Integer swappingId;
    Integer valid;
    String creatorRollNum;
    String courseNameFrom;
    String courseSecFrom;
    String courseNameTo;
    String courseSecTo;

    public Swapping(Integer swappingId, Integer valid, String creatorRollNum, String courseNameFrom, String courseSecFrom, String courseNameTo, String courseSecTo) {
        this.swappingId = swappingId;
        this.valid = valid;
        this.creatorRollNum = creatorRollNum;
        this.courseNameFrom = courseNameFrom;
        this.courseSecFrom = courseSecFrom;
        this.courseNameTo = courseNameTo;
        this.courseSecTo = courseSecTo;
    }

    public Swapping() {
    }

    @Column(name = "swapping_id", nullable = false)
    public Integer getSwappingId() {
        return swappingId;
    }

    public void setSwappingId(Integer swappingId) {
        this.swappingId = swappingId;
    }

    @Column(name = "valid", nullable = false)
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Column(name = "creator_roll_num", nullable = false)
    public String getCreatorRollNum() {
        return creatorRollNum;
    }

    public void setCreatorRollNum(String creatorRollNum) {
        this.creatorRollNum = creatorRollNum;
    }

    @Column(name = "course_name_from", nullable = false)
    public String getCourseNameFrom() {
        return courseNameFrom;
    }

    public void setCourseNameFrom(String courseNameFrom) {
        this.courseNameFrom = courseNameFrom;
    }

    @Column(name = "course_sec_from", nullable = false)
    public String getCourseSecFrom() {
        return courseSecFrom;
    }

    public void setCourseSecFrom(String courseSecFrom) {
        this.courseSecFrom = courseSecFrom;
    }

    @Column(name = "course_name_to", nullable = false)
    public String getCourseNameTo() {
        return courseNameTo;
    }

    public void setCourseNameTo(String courseNameTo) {
        this.courseNameTo = courseNameTo;
    }

    @Column(name = "course_sec_to", nullable = false)
    public String getCourseSecTo() {
        return courseSecTo;
    }

    public void setCourseSecTo(String courseSecTo) {
        this.courseSecTo = courseSecTo;
    }

    @Override
    public String toString() {
        return "Swapping{" +
                "swappingId='" + swappingId + '\'' +
                ", creatorRollNum='" + creatorRollNum + '\'' +
                ", courseNameFrom='" + courseNameFrom + '\'' +
                ", courseSecFrom='" + courseSecFrom + '\'' +
                ", courseNameTo='" + courseNameTo + '\'' +
                ", courseSecTo='" + courseSecTo + '\'' +
                '}';
    }
}
