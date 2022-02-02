package se.kth.iv1201.group6.recruitmentApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor Pettersson last changed 2022-02-02
 */
@RestController
public class testController {
    @GetMapping("/test")
    public String test(){
        return "apa";
    }
}
