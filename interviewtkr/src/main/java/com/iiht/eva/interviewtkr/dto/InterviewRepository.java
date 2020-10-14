package com.iiht.eva.interviewtkr.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.eva.interviewtkr.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    List<Interview> findByInterviewName(String interviewName);
    List<Interview> findAllByInterviewer(String interviewer);
}

