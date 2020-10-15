package com.iiht.eva.interviewtkr.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iiht.eva.interviewtkr.entity.Interview;
import com.iiht.eva.interviewtkr.entity.User;
import com.iiht.eva.interviewtkr.service.InterviewService;



//http://localhost:9696/trackerapp/api/interviews

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    //List of Interviews
    @GetMapping({"", "/"})
    public List<Interview> getInterviews() {
        return interviewService.getInterviews();
    }

    //http://localhost:9696/trackerapp/api/interviews/1
    @GetMapping("/{id}")
    public Interview getInterviewById(@PathVariable(value = "id") int id) {
        return interviewService.findByInterviewId(id);
    }
   
    //http://localhost:9696/trackerapp/api/interviews/interview/Q2E
    @GetMapping("/interview/{name}")
    public List<Interview> getInterviewByName(@PathVariable(value = "name") String name) {
        return interviewService.findAllByInterviewName(name);
    }

    //http://localhost:9696/trackerapp/api/interviews/interviewer/Trimurthulu
    @GetMapping("/interviewer/{name}")
    public List<Interview> getInterviewBy(@PathVariable(value = "name") String interviewer) {
        return interviewService.findAllByInterviewer(interviewer);
    }

    //http://localhost:9696/trackerapp/api/interviews/attendees/1
    @GetMapping("/attendees/{interviewId}")
    public Set<User> getAttendees(@PathVariable(value = "interviewId") int interviewId) {
        return interviewService.findByInterviewId(interviewId).getUsers();
    }

    //http://localhost:9696/trackerapp/api/interviews/updateStatus/2/in-progress
    @PutMapping("/updateStatus/{interviewId}/{interviewStatus}")
    public Interview updateInterviewStatus(@PathVariable(value = "interviewId") int interviewId, @PathVariable(value = "interviewStatus") String interviewStatus) {
        return interviewService.updateInterviewStatus(interviewId,interviewStatus);
    }

    //Interviews count
    @GetMapping("/count")
    public int getInterviewCount() {

        return interviewService.getInterviewsCount();
    }

    //Body:{ "interviewId": 1, "interviewName": "Q2E", "interviewer": "Trimurthulu", "skills": "QA,Devlopment", "time": "21:16:33", "date": "2020-10-13", "status": "Confirmed", "remarks": "Urgent" }
    @PostMapping({"", "/"})
    public Interview addInterview(@RequestBody Interview interview) {

        return interviewService.addInterview(interview);
    }
    
    //Adding Attendee to a interview 
    //http://localhost:9696/trackerapp/api/interviews/addUsers/1/1
    @PutMapping({"/addUsers/{interviewId}/{userId}"})
    public Interview addUsers(@PathVariable(value = "interviewId") int interviewId, @PathVariable(value = "userId") int userId) {
        return interviewService.addUsersToInterview(interviewId, userId);
    }

    //Removing the attendee from the interview
    //http://localhost:9696/trackerapp/api/interviews/removeUsers/2/2
    @PutMapping({"/removeUsers/{interviewId}/{userId}"})
    public Interview removeUsers(@PathVariable(value = "interviewId") int interviewId, @PathVariable(value = "userId") int userId) {
        return interviewService.removeUsersFromInterview(interviewId, userId);
    }

    //Update interview details
    @PutMapping({"", "/"})
    public Interview updateInterview(@RequestBody Interview interview) {
        return interviewService.updateInterview(interview);
    }

    //Delete interview
    //http://localhost:9696/trackerapp/api/interviews/1
    @DeleteMapping({"/{id}"})
    public void deleteInterview(@PathVariable(value = "id") int id) {
        interviewService.deleteInterview(id);
    }
}