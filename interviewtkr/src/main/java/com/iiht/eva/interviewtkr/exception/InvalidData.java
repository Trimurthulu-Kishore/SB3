package com.iiht.eva.interviewtkr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidData extends RuntimeException {
    public InvalidData(String msg) {
        super(msg);
    }

    public InvalidData(List<String> msgs) {
        this(String.join(";", msgs));
    }

}
