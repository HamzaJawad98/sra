package com.example.sra.userNotif;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "user_notif")
public class UserNotif {
    @Id
    String rollNum;
    String _message;

    public UserNotif(String rollNum, String _message) {
        this.rollNum = rollNum;
        this._message = _message;
    }

    public UserNotif() {
    }

    @Column(name = "roll_num", nullable = false)
    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    @Column(name = "_message", nullable = false)
    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    @Override
    public String toString() {
        return "UserNotif{" +
                "rollNum='" + rollNum + '\'' +
                ", _message='" + _message + '\'' +
                '}';
    }
}