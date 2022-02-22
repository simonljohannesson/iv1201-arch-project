package se.kth.iv1201.group6.recruitmentApplication.dto;

/**
 * This class defines the error message sent to users of the API.
 */
public class ApiError {
    public int status;
    public String error;
    public String message;
    public int errorCode;
}
