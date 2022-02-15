package se.kth.iv1201.group6.recruitmentApplication.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonNumberValidator implements ConstraintValidator<PersonNumberValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return personalNumberValidation(s);
    }

    /**
     * Validates a personal number with Luhn algorithm.
     * @param pnr
     * @return
     */
    private boolean personalNumberValidation(String pnr) {
         if(pnr.length() != 12) return false;
         int digits = pnr.length();
         int sum = 0;
         for (int i = digits - 1; i >= 2; i--) {
             char c = pnr.charAt(i);
             if(!Character.isDigit(c)) return false;
             int n = c - '0';
             if (i % 2 == 0) 
                n += n;
             sum += n / 10; // most significant digit
             sum += n % 10; // least significant digit
         }
         return (sum % 10 == 0);
    }
}
