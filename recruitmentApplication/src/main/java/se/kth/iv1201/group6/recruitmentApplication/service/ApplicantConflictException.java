package se.kth.iv1201.group6.recruitmentApplication.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.kth.iv1201.group6.recruitmentApplication.enums.ReasonEnum;

@ResponseStatus(HttpStatus.CONFLICT)
public class ApplicantConflictException extends Exception {
    private ReasonEnum reason;

    public ReasonEnum getReason(){
        return reason;
    }

    public ApplicantConflictException(ReasonEnum reason) {
        this.reason = reason;
    }

    public ApplicantConflictException(ReasonEnum reason, String msg) {
        super(msg);
        this.reason = reason;
    }
}
