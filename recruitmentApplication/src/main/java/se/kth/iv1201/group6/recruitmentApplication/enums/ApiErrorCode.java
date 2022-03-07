package se.kth.iv1201.group6.recruitmentApplication.enums;

/**
 * All error codes that can be presented by the API to give a more granular reason to an error.
 *
 *
 */
public enum ApiErrorCode {

    // GENERAL ERROR CODES
    NOT_DEFINED(0),


    // USERS

    DUPLICATE_EMAIL(100),
    DUPLICATE_USERNAME(101),
    DUPLICATE_PNR(102),
    NOT_FOUND(103);




    private final int value;

    ApiErrorCode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
