package com.iiht.eva.interviewtkr.service;

import com.iiht.eva.interviewtkr.dto.InterviewRepository;
import com.iiht.eva.interviewtkr.dto.UserRepository;
import com.iiht.eva.interviewtkr.entity.*;
import com.iiht.eva.interviewtkr.exception.InvalidData;
import com.iiht.eva.interviewtkr.utils.InterviewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Interview> getInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public int getInterviewsCount() {
        return interviewRepository.findAll().size();
    }

    @Override
    public Interview findByInterviewId(int interviewId) {
        return interviewRepository.findById(interviewId).orElseThrow(() -> new InvalidData("Interview Id : " + interviewId + " is not found."));
    }

    @Override
    public List<Interview> findAllByInterviewName(String interviewName) {
        return interviewRepository.findByInterviewName(interviewName);
    }

    @Override
    public List<Interview> findAllByInterviewer(String interviewer) {
        return interviewRepository.findAllByInterviewer(interviewer);
    }

    @Override
    @Transactional
    public Interview addInterview(Interview interview) {
        InterviewValidator interviewValidator = new InterviewValidator();
        if (interviewValidator.validateInterview(interview)) {
            if (interviewRepository.findById(interview.getInterviewId()).isPresent())
                return interviewRepository.save(interview);
            else
                throw new InvalidData("Interview Id is already Exists in the System .");
        } else
            throw new InvalidData(interviewValidator.getErrors());
    }

    @Override
    public void deleteInterview(int interviewId) {

        if (interviewRepository.findById(interviewId).isPresent())
            interviewRepository.deleteById(interviewId);
        else
            throw new InvalidData("Interview Id is not found in the system.");
    }

    @Override
    public Interview updateInterview(Interview interview) {
        InterviewValidator interviewValidator = new InterviewValidator();
        if (interviewValidator.validateInterview(interview)) {
            if (!interviewRepository.findById(interview.getInterviewId()).isPresent())
                throw new InvalidData("Interview Id is not found in the system.");
            else
                return interviewRepository.save(interview);
        } else
            throw new InvalidData(interviewValidator.getErrors());
    }

    @Override
    public Interview addUsersToInterview(int interviewId, int userId) {
        Interview interview = interviewRepository.findById(interviewId).orElseThrow(() -> new InvalidData("Interview Id : " + interviewId + " is not found in the system."));
        User user = userRepository.findById(userId).orElseThrow(() -> new InvalidData("User Id : " + userId + " esists in the system."));
        if (interview.getUsers().stream().noneMatch(user1 -> user1.getUserId() == userId)) {
            interview.getUsers().add(user);
            return interviewRepository.save(interview);
        } else
            throw new InvalidData("User Id : " + userId + " is already Aligned");
    }
}
