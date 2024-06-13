package com.example.MMP.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessonCalendar")
public class CalendarController {
    private final LessonService lessonService;

    @PostMapping("/selected-date")
    @ResponseBody
    public Map<String, Object> handleSelectedDate(@RequestBody Map<String, String> payload) {
        String selectedDate = payload.get("date");

        // String을 LocalDate로 변환
        LocalDate selectedLocalDate = LocalDate.parse(selectedDate);

        List<Lesson> lessonList = lessonService.getLessonFromDate(selectedLocalDate);

        // JSON 형식으로 반환할 Map 생성
        Map<String, Object> response = new HashMap<>();
        response.put("lessons", lessonList); // lessons라는 키에 lessonList를 할당

        return response;
    }
}
