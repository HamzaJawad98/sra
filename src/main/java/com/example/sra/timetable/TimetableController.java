package com.example.sra.timetable;

import com.example.sra.otherModels.CoursePlusTimetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TimetableController {
    @Autowired
    private TimetableServiceRepo timetableServiceRepo;

    @GetMapping("/timetable")
    public List<Timetable> getAllTimetables() {
        return timetableServiceRepo.findAll();
    }
    
    @PostMapping("/generateTimetable")
    public Map<String, List<CoursePlusTimetable>> getTimetableForCourses(@RequestBody List<String> courseIDs) {
        try {
            Map<String, List<CoursePlusTimetable>> map = new HashMap<>();
            List<CoursePlusTimetable> answers = new ArrayList<>();
            List<CoursePlusTimetable> oneCourseSections = new ArrayList<>();
            Boolean noClash = false;
            List<CoursePlusTimetable> clashAnswers = new ArrayList<>();
            for (int i = 0; i < courseIDs.size(); i++) {
                noClash = false;
                oneCourseSections = timetableServiceRepo.getTimetableForCourses(courseIDs.get(i));
                if (answers.size() > 0) {
                    for (int j = 0; j < answers.size(); j++) {
                        for (int k = 0; k < oneCourseSections.size(); k++) {
                            if (!(oneCourseSections.get(k).getTimeId() == answers.get(j).getTimeId())) {
                                answers.add(oneCourseSections.get(k));
                                noClash = true;
                            }
                        }
                        if (noClash == false) {
                            clashAnswers.add(oneCourseSections.get(0));
                            clashAnswers.add(answers.get(0));
                            break;
                        }
                    }
                } else {
                    answers.add(oneCourseSections.get(0));
                }
            }
            if (noClash == true) {
                map.put("Success", answers);
            } else {
                map.put("Failure", clashAnswers);
            }
            return map;
        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping("/getTimetable")
    public List<CoursePlusTimetable> getTimetable() {
        try {
            return timetableServiceRepo.getTimetable();
        }
        catch (Exception e){
            return null;
        }
    }
}
