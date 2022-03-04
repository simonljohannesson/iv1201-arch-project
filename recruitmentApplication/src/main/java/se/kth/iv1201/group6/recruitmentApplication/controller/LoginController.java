package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Controller class used for nothing except being open so that a user can authenticate and receive a cookie.
 */
@RestController
public class LoginController {

    /**
     * If user is authenticated will return http status 200 otherwise 401 or 403.
     * @param user
     * @return
     */
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    @GetMapping("/user")
    public Object user(Principal user) {
        return new Object(){
            public final boolean authenticated = true;
        };
    }

}
