package Hbence.movieGeneratorAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    //Bejelentkezes
    @GetMapping("/")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        return "";
    }
}
