package com.iiht.eva.interviewtkr.entity;

import java.util.ArrayList;
import java.util.List;
import com.iiht.eva.interviewtkr.entity.User;

public class UserValidator {
    private List<String> errors;

    public boolean validateUser(User user) {
        errors = new ArrayList<>();
        if (null != user) {
            if (user.getUserId() == 0)
                errors.add("User Id is shoudn't be 0");

            if (null != user.getFname()) {
                int fNameLen = user.getFname().trim().length();
                if (fNameLen != 0) {
                    if (fNameLen < 5 || fNameLen > 30)
                        errors.add("FName length should be min. 5 and max. 30 characters.");
                } else
                    errors.add("First Name can't be blank.");
            } else
                errors.add("First Name is Must.");

            if (null != user.getlName()) {
                int lNameLen = user.getlName().trim().length();
                if (lNameLen > 0) {
                    if (lNameLen < 3 || lNameLen > 25)
                        errors.add("Last name length should be min. 3 and max. 25 characters.");
                } else
                    errors.add("Last Name can't be blank.");
            } else
                errors.add("Last Name is Must.");


            if (null != user.getEmail()) {
                int emailLen = user.getEmail().trim().length();
                if (emailLen > 0) {
                    if (!user.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
                        errors.add("Email:" + user.getEmail() + " is invalid.");
                } else
                    errors.add("email can't be blank.");
            } else
                errors.add("email is required.");


            if (null != user.getMobile()) {
                if (!user.getMobile().matches("^\\d{10}$"))
                    errors.add("Mobile:" + user.getMobile() + " is not valid number.");
            } else
                errors.add("mobile number is required.");

        } else
            errors.add("User is must");

        return !(errors.size() > 0);
    }

    public List<String> getErrors() {
        return errors;
    }
}