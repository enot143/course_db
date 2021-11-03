package db.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping
    public String main(Model model) {
        return "index";
    }
//    @RequestMapping("/")
//    public ModelAndView index () {
//        ModelAndView modelAndView = new ModelAndView();
//        HashMap<Object, Object> data = new HashMap<>();
//        data.put("people", humanRepo.findAll());
//        modelAndView.getModelMap().addAttribute("frontendData", data);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
}