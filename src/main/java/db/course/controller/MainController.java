package db.course.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    //    @GetMapping
//    public String main(Model model, @AuthenticationPrincipal User user) {
//        model.addAttribute("profile", user);
//        return "index";
//    }
    @GetMapping
    public String main(Model model) {
        return "index";
    }
}