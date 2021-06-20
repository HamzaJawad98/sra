package com.example.sra.teacher;

import com.example.sra.swapping.Swapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherServiceRepo extends JpaRepository<Teacher, String>{

}
