package com.iiht.eva.interviewtkr.utils;

import com.iiht.eva.interviewtkr.entity.Interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewValidator {
    private List<String> errors;

    public boolean validateInterview(Interview interview) {
        errors = new ArrayList<>();
        if (null != interview) {
            if (interview.getInterviewId() == 0)
                errors.add("Interview Id should not be 0");

            if (null != interview.getInterviewName()) {
                int interviewNameLen = interview.getInterviewName().trim().length();
                if (interviewNameLen != 0) {
                    if (interviewNameLen < 3 || interviewNameLen > 30)
                        errors.add("Interview Name length should be Min 3 and Max 30 Chars.");
                } else
                    errors.add("Interview Name Shouldn't be Blank");
            } else
                errors.add("Interview Name is Must.");

            if (null != interview.getInterviewer()) {
                int interviewerNameLen = interview.getInterviewer().trim().length();
                if (interviewerNameLen > 0) {
                    if (interviewerNameLen < 5 || interviewerNameLen > 30)
                        errors.add("Interviewer name length should be Min 3 and Max 30 Chars.");
                } else
                    errors.add("Interviewer Name Shouldn't be Blank.");
            } else
                errors.add("Interviewer Name is Must.");

            if (null != interview.getSkills()) {
                int skillsLen = interview.getSkills().trim().length();
                if (skillsLen != 0) {
                    if (skillsLen < 5 || skillsLen > 30)
                        errors.add("Skills length should be min 5 and max 30 Chars.");
                } else
                    errors.add("Skills Name Shouldn't be Blank.");
            } else
                errors.add("Skills Name is required.");

            if (null != interview.getStatus()) {
                int statusLen = interview.getStatus().trim().length();
                if (statusLen != 0) {
                    if (statusLen < 5 || statusLen > 100)
                        errors.add("Status length should be min 5 and max 100 Chars.");
                } else
                    errors.add("Status Name Shouldn't be Blank.");
            } else
                errors.add("Status Name is required.");

            if (null != interview.getRemarks()) {
                int remarksLen = interview.getRemarks().trim().length();
                if (remarksLen != 0) {
                    if (remarksLen < 5 || remarksLen > 100)
                        errors.add("Remarks length should be between 5 to 100 Chars.");
                } else
                    errors.add("Remarks Name Shouldn't be Blank.");
            } else
                errors.add("Remarks Name is required.");
        } else
            errors.add("interview is Must");

        return !(errors.size() > 0);
    }

    public List<String> getErrors() {
        return errors;
    }


}
