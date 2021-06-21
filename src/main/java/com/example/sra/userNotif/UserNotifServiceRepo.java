package com.example.sra.userNotif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotifServiceRepo extends JpaRepository<UserNotif, String>{
    @Query(value = "select * from user_notif where roll_num = :rollNum", nativeQuery = true)
    List<UserNotif> getUserNotifications(@Param("rollNum") String rollNum);
}
