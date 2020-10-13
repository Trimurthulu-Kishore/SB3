package com.iiht.eva.interviewtkr.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "interview")
public class Interview {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interviewId;

    @NotNull
    @Column(name = "title")
    private String interviewName;

    @NotNull
    @Column(name = "interviewer")
    private String interviewer;

    @NotNull
    @Column(name = "skills")
    private String skills;

    @Column(name = "start_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "remarks")
    private String remarks;

    @OneToMany
    @JoinTable(name = "interview_user",
            joinColumns = {@JoinColumn(name = "interview_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public String getInterviewName() {
        return interviewName;
    }

    public void setInterviewName(String interviewName) {
        this.interviewName = interviewName;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Interview(@NotNull int interviewId, String interviewName, String interviewer, String skills, LocalTime time, LocalDate date, String status, String remarks) {
        this.interviewId = interviewId;
        this.interviewName = interviewName;
        this.interviewer = interviewer;
        this.skills = skills;
        this.time = time;
        this.date = date;
        this.status = status;
        this.remarks = remarks;
    }

    public Interview(@NotNull int interviewId) {
        this.interviewId = interviewId;
    }

    public Interview() {
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interviewId=" + interviewId +
                ", interviewName='" + interviewName + '\'' +
                ", interviewer='" + interviewer + '\'' +
                ", skills='" + skills + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
