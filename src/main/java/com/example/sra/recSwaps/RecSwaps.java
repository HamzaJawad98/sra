package com.example.sra.recSwaps;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "received_swap_req")
public class RecSwaps {
    @Id
    Integer swappingId;
    Integer valid;
    String senderRollNum;

    public RecSwaps(Integer swappingId, String senderRollNum) {
        this.swappingId = swappingId;
        this.senderRollNum = senderRollNum;
    }

    public RecSwaps(){

    }

    @Column(name = "swapping_id", nullable = false)
    public Integer getSwappingId() {
        return swappingId;
    }

    public void setSwappingId(Integer swappingId) { this.swappingId = swappingId; }

    @Column(name = "valid", nullable = false)
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Column(name = "sender_roll_num", nullable = false)
    public String getSenderRollNum() {
        return senderRollNum;
    }

    public void setSenderRollNum(String senderRollNum) {
        this.senderRollNum = senderRollNum;
    }

    @Override
    public String toString() {
        return "RecSwaps{" +
                "swappingId=" + swappingId +
                ", senderRollNum='" + senderRollNum + '\'' +
                '}';
    }
}