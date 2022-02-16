package se.kth.iv1201.group6.recruitmentApplication;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return """
        <html>
            <body>
                <h1 style=\"color:red\">Welcome to our app</h1>
                <p style=\"color:green\">You should try some other path</p>
            </body>
        </html>
        """;
    }
    @GetMapping("/hello_auth_app")
    @PreAuthorize("hasAnyRole('ROLE_APPLICANT')")
    public String hello_auth_applicant(){
        return """
        <html>
            <body>
                <h1 style=\"color:violet\">You are an authorized applicant</h1>
                <p style=\"color:orange\">That is so nice!!</p>
            </body>
        </html>
        """;
    }

    @GetMapping("/hello_auth_rec")
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    public String hello_auth_recruiter(){
        return """
        <html>
            <body>
                <h1 style=\"color:blue\">You are an authorized recruiter</h1>
                <p style=\"color:orange\">That is so nice!!</p>
            </body>
        </html>
        """;
    }
}
