package com.iiht.eva.interviewtkr.utils;

import com.iiht.eva.interviewtkr.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    private List<String> errors;

    public boolean validateUser(User user) {
        errors = new ArrayList<>();
        if (null != user) {
            if (user.getUserId() == 0)
                errors.add("User Id shouldn't be 0");

            if (null != user.getFname()) {
                int fNameLen = user.getFname().trim().length();
                if (fNameLen != 0) {
                    if (fNameLen < 5 || fNameLen > 30)
                        errors.add("First Name length should be min 5 and Max 30 Chars.");
                } else
                    errors.add("First Name Shouldn't be Blank.");
            } else
                errors.add("First Name is required.");

            if (null != user.getlName()) {
                int lNameLen = user.getlName().trim().length();
                if (lNameLen > 0) {
                    if (lNameLen < 3 || lNameLen > 25)
                        errors.add("Last Name length should be min 3 and max 25 Chars.");
                } else
                    errors.add("Last Name Shouldn't be Blank.");
            } else
                errors.add("Last Name is required.");


            if (null != user.getEmail()) {
                int emailLen = user.getEmail().trim().length();
                if (emailLen > 0) {
                    if (!user.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
                        errors.add("Email:" + user.getEmail() + " is invalid.");
                } else
                    errors.add("email Shouldn't be Blank.");
            } else
                errors.add("email is required.");


            if (null != user.getMobile()) {
                if (!user.getMobile().matches("^\\d{10}$"))
                    errors.add("Mobile:" + user.getMobile() + " is invalid.");
            } else
                errors.add("mobile number is required.");

        } else
            errors.add("User is Must");

        return !(errors.size() > 0);
    }

    public List<String> getErrors() {
        return errors;
    }


}