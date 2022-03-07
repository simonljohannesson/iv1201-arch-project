package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class LoginController {

    @PreAuthorize("hasAnyRole('ROLE_RECRUITER', 'ROLE_APPLICANT')")
    @GetMapping("/user")
    public Object user(Principal user) {
        return new Object(){
            public final boolean authenticated = true;
        };
    }

}
