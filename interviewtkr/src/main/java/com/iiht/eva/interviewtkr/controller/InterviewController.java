package com.iiht.eva.interviewtkr.controller;

import com.iiht.eva.interviewtkr.entity.Interview;
import com.iiht.eva.interviewtkr.entity.User;
import com.iiht.eva.interviewtkr.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @GetMapping({"", "/"})
    public List<Interview> getInterviews() {
        return interviewService.getInterviews();
    }

    @GetMapping("/{id}")
    public Interview getInterviewById(@PathVariable(value = "id") int id) {
        return interviewService.findByInterviewId(id);
    }

    @GetMapping("/interview/{name}")
    public List<Interview> getInterviewByName(@PathVariable(value = "name") String name) {
        return interviewService.findAllByInterviewName(name);
    }

    @GetMapping("/interviewer/{name}")
    public List<Interview> getInterviewBy(@PathVariable(value = "name") String interviewer) {
        return interviewService.findAllByInterviewer(interviewer);
    }

    @GetMapping("/attendees/{interviewId}")
    public List<User> getAttendees(@PathVariable(value = "interviewId") int interviewId) {
        return interviewService.findByInterviewId(interviewId).getUsers();
    }

    @GetMapping("/count")
    public int getInterviewCount() {

        return interviewService.getInterviewsCount();
    }

    @PostMapping({"", "/"})
    public Interview addInterview(@RequestBody Interview interview) {

        return interviewService.addInterview(interview);
    }

    @PostMapping({"/addUsers"})
    public Interview addUsers(@RequestBody Map<String, Integer> details) {
        int userId = details.get("userId");
        int interviewId = details.get("interviewId");
        return interviewService.addUsersToInterview(interviewId, userId);
    }

    @PutMapping({"", "/"})
    public Interview updateInterview(@RequestBody Interview interview) {
        return interviewService.updateInterview(interview);
    }

    @DeleteMapping({"/{id}"})
    public void deleteInterview(@PathVariable(value = "id") int id) {
        interviewService.deleteInterview(id);
    }

}

