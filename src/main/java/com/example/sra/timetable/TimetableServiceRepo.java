package com.example.sra.timetable;
import com.example.sra.otherModels.CoursePlusTimetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableServiceRepo extends JpaRepository<Timetable, String>{
    @Query(value = "select c.course_name AS courseName, " +
            "c.time_id AS timeId, c.section As sections, c.venue As venue from (select c.course_name, c.course_id, t.time_id, t.section, t.venue\n" +
            "from Timetable t \n" +
            "join Course c on c.course_id = t.course_id) c where c.course_id = :courseId", nativeQuery = true)
    List<CoursePlusTimetable> getTimetableForCourses(@Param("courseId") String courseId);

    @Query(value = "select c.course_name AS courseName, " +
            "c.time_id AS timeId, c.section As sections, c.venue As venue from (select c.course_name, c.course_id, t.time_id, t.section, t.venue\n" +
            "from Timetable t \n" +
            "join Course c on c.course_id = t.course_id) c", nativeQuery = true)
    List<CoursePlusTimetable> getTimetable();
}
