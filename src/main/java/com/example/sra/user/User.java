package com.example.sra.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "_user")
public class User {
    @Id
    private String roll_num;
    private String username;
    private String passw;
//    private Long id;


    public User() {

    }

    public User(String roll_num, String username, String passw) {
        this.roll_num = roll_num;
        this.username = username;
        this.passw = passw;
    }

    @Column(name = "roll_num", nullable = false)
    public String getroll_num() {
        return roll_num;
    }

    @Column(name = "username", nullable = false)
    public String getName() {
        return username;
    }

    @Column(name = "passw", nullable = false)
    public String getpassw() {
        return passw;
    }

    public void setroll_num(String roll_num) {
        this.roll_num = roll_num;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setpassw(String passw) {
        this.passw = passw;
    }

    @Override
    public String toString() {
        return "User{" +
                "roll_num='" + roll_num + '\'' +
                ", name='" + username + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }
}
