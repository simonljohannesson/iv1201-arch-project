package se.kth.iv1201.group6.recruitmentApplication.exception;


import se.kth.iv1201.group6.recruitmentApplication.enums.ReasonEnum;

/**
 * Represents some conflict with applicants.
 */
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
