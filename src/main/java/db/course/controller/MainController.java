package db.course.controller;

import db.course.exceptions.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Controller
public class MainController {
//    @GetMapping("user")
//    public ResponseEntity<?> main(@AuthenticationPrincipal User user) {
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//    @GetMapping
//    public String main(Model model) {
//        return "index";
//    }
}