package db.course.controller;

import db.course.domain.Human;
import db.course.repos.HumanRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("human")
public class HumanController {
  private final HumanRepo humanRepo;

    @Autowired
    public HumanController(HumanRepo humanRepo) {
        this.humanRepo = humanRepo;
    }

    @GetMapping
    public List<Human> list() {
        return humanRepo.findAll();
    }
//    @GetMapping
//    public ModelAndView index () {
//        ModelAndView modelAndView = new ModelAndView();
//        HashMap<Object, Object> data = new HashMap<>();
//        data.put("people", humanRepo.findAll());
//        modelAndView.getModelMap().addAttribute("frontendData", data);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
    @GetMapping("{human_id}")
    public Human getOne(@PathVariable("human_id") Human human) {
        return human;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Human human){
        try {
            System.out.println(human.toString());
            return new ResponseEntity<>(humanRepo.save(human), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMostSpecificCause().getMessage());
            if (e.getMostSpecificCause().getMessage().contains("human_age_check")){
                return new ResponseEntity<>("human_age_check error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return null;
    }

    //TODO:check
    @PutMapping("{human_id}")
    public Human update(@PathVariable("human_id") Human humanFromDb,
                                      @RequestBody Human human) {
        BeanUtils.copyProperties(human, humanFromDb, "human_id");
        return humanRepo.save(humanFromDb);
    }

    @DeleteMapping("{human_id}")
    public void delete(@PathVariable("human_id") Human human) {
            humanRepo.delete(human);
    }
}
