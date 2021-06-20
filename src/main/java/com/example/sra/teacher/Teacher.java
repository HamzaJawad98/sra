package com.example.sra.teacher;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    private String tName;


    public Teacher() {

    }

    public Teacher(String tName) {
        this.tName = tName;
    }
    @Column(name = "t_name", nullable = false)
    public String getTeacherName() {
        return tName;
    }

    public void setName(String username) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + tName + '\'' +
                '}';
    }
}
