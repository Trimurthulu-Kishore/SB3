package com.iiht.eva.interviewtkr.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jsonid")
public class User {
   
	@Id
    @NotNull(message = "User id is required.")
    private int userId;

    @Column
    @NotEmpty(message = "Please enter FirstName")
    @Size(min = 5, max = 30,message = "First Name should be minimun 5 charecters and maximum 30 characters")
    private String fname;

    @Column
    @NotEmpty(message = "Please enter LastName")
	@Size(min = 3, max = 25,message = "Last Name should be minimun 3 charecters and maximum 25 characters")
    private String lName;

    @Column
    @NotEmpty(message = "Please enter the email")
	@Email(message = "Please enter valid email address")
    private String email;

    @Column
    @NotNull(message = "Please provide mobile number")
	@Length(min = 10, max = 10,message = "Mobile number should be 10 digits")
    private String mobile;

    @ManyToMany(mappedBy = "users")
    private Set<Interview> interviews;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fname='" + fname + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", interviews=" + interviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public void copyUser(User user) {
        this.setEmail(user.getEmail());
        this.setFname(user.getFname());
        this.setlName(user.getlName());
        this.setMobile(user.getMobile());
    }
}