package com.example.sra.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepo extends JpaRepository<User, String>{
    @Query(value = "Select * FROM _user where roll_num= :rollNum and passw= :pwd" , nativeQuery = true)
    User authenticate(@Param("rollNum") String rollNum, @Param("pwd")String pwd);

    @Query(value = "insert into _user OUTPUT 'true' " +
            "values(:rollNum,:uname, :pwd)", nativeQuery = true)
    String register(@Param("rollNum") String rollNum,@Param("uname")String uname,@Param("pwd")String pwd);
}
