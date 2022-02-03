package se.kth.iv1201.group6.recruitmentApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
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
}
