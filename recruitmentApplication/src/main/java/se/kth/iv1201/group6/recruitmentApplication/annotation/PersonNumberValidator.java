package se.kth.iv1201.group6.recruitmentApplication.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator class for validation of person numbers.
 */
public class PersonNumberValidator implements ConstraintValidator<PersonNumberValidation, String> {

    /**
     * Checks if a person number is valid
     * @param s person number to check
     * @param constraintValidatorContext
     * @return
     */
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
         if(pnr == null) return false;
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
