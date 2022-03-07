package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Controller class used for nothing except being open so that a user can authenticate and receive a cookie.
 */
@RestController
@PreAuthorize("hasAnyRole('ROLE_RECRUITER', 'ROLE_APPLICANT')")
public class LoginController {
    @GetMapping("/user")
    public Object user(Principal user) {
        return new Object(){
            public final boolean authenticated = true;
        };
    }

}
