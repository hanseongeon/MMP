package com.example.MMP.lesson;

import com.example.MMP.homeTraining.HomeTrainingForm;
import com.example.MMP.homeTraining.category.Category;
import com.example.MMP.siteuser.SiteUser;
import com.example.MMP.siteuser.SiteUserService;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;
    private final SiteUserService siteUserService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    private String create(LessonForm lessonForm){
        return "lesson/lesson_create";
    }

    @PostMapping("/create")
    private String create(@Valid LessonForm lessonForm, BindingResult bindingResult, Principal principal){

        if(bindingResult.hasErrors()){
            return "lesson/lesson_create";
        }
        SiteUser trainer = siteUserService.getUser(principal.getName());

        lessonService.create(lessonForm.getLessonName(), lessonForm.getHeadCount(), lessonForm.getLessonDate(), lessonForm.getStartTime(), lessonForm.getEndTime(), trainer);

        return "redirect:/schedule";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, Principal principal){
        Lesson lesson = lessonService.getLesson(id);
        String currentUsername = principal.getName();

        boolean isUserAttending = lesson.getAttendanceList().stream()
                .anyMatch(attendant -> attendant.getUserId().equals(currentUsername));

        boolean isLessonAttended;
        if(isUserAttending){
            if (lesson.getAttendanceList().size() <= lesson.getHeadCount()){//예약신청이 된 상태, 예약리스트길이가 인원수와 같거나 작을 때. --> 예약 완료
                isLessonAttended = true;
            }else {//예약신청이 된 상태, 예약리스트길이가 인원수보다 클 때. --> 대기 완료
                isLessonAttended = false;
            }
        }else {
            if (lesson.getAttendanceList().size() < lesson.getHeadCount()){//예약신청이 안된 상태, 예약리스트길이가 인원수와 같거나 클 때. --> 대기 하기
                isLessonAttended = false;
            }else {//예약신청이 안된 상태, 예약리스트길이가 인원수보다 작을 때 --> 예약 하기
                isLessonAttended = true;
            }
        }

        model.addAttribute("lesson", lesson);
        model.addAttribute("isUserAttending", isUserAttending);
        model.addAttribute("isLessonAttended", isLessonAttended);
        return "lesson/lesson_detail";
    }

    @GetMapping("/reservation/{id}")
    public String reservation(@PathVariable("id") Long id, Principal principal){
        Lesson lesson = lessonService.getLesson(id);
        SiteUser siteUser = siteUserService.getUser(principal.getName());

        lessonService.reservation(lesson, siteUser);
        return "redirect:/lesson/detail/" + id;
    }

    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable("id") Long id, Principal principal){
        Lesson lesson = lessonService.getLesson(id);
        SiteUser siteUser = siteUserService.getUser(principal.getName());

        lessonService.cancel(lesson, siteUser);
        return "redirect:/lesson/detail/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Lesson lesson = lessonService.getLesson(id);
        lessonService.delete(lesson);
        return "redirect:/schedule";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, LessonForm lessonForm){
        Lesson lesson = lessonService.getLesson(id);
        lessonForm.setLessonName(lesson.getLessonName());
        lessonForm.setHeadCount(String.valueOf(lesson.getHeadCount()));
        lessonForm.setLessonDate(lesson.getLessonDate());
        lessonForm.setStartTime(lesson.getStartTime());
        lessonForm.setEndTime(lesson.getEndTime());
        return "lesson/lesson_create";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid LessonForm lessonForm, BindingResult bindingResult){
        Lesson lesson = lessonService.getLesson(id);
        if(bindingResult.hasErrors()){
            return "lesson/lesson_create";
        }
        lessonService.update(lesson, lessonForm.getLessonName(), lessonForm.getHeadCount(), lessonForm.getLessonDate(), lessonForm.getStartTime(), lessonForm.getEndTime());
        return "redirect:/lesson/detail/" + id;
    }

    @GetMapping("/my-schedule")
    @ResponseBody
    public List<Lesson> getMySchedule() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        SiteUser siteUser = siteUserService.findByUserName(username);
        List<Lesson> lessonList;
        if (siteUser.getUserRole().equals("user")){
            lessonList = lessonService.getLessonsAttendingByUsername(username);
        }else {
            lessonList = siteUserService.getLessonList(siteUser);
        }
        return lessonService.sortLessonsByDateDesc(lessonList);
    }
}
