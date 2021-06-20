package com.example.sra.userNotif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNotifServiceRepo extends JpaRepository<UserNotif, String>{
}
