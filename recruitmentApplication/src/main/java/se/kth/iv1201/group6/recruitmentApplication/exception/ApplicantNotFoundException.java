package se.kth.iv1201.group6.recruitmentApplication.exception;

/**
 * The exception that is used by controllers to display an error to a user of its API.
 *
 * The http status code given to the constructor will be shown to the user receiving the error.
 */
public class ApplicantNotFoundException extends Exception {
    public ApplicantNotFoundException(String msg) {
        super(msg);
    }
}
