package se.kth.iv1201.group6.recruitmentApplication.enums;

public enum UserRole {
    APPLICANT(2), RECRUITER(1);

    private int value;

    public int getValue () {return value;}

    UserRole(int value){
        this.value = value;
    }
}
