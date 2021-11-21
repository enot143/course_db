package db.course.controller;


import db.course.domain.Performer;
import db.course.form.PerformerForm;
import db.course.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("performer")
public class PerformerController {
    @Autowired
    private final PerformerService performerService;

    public PerformerController(PerformerService performerService) {
        this.performerService = performerService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return performerService.findAll();
    }

    @GetMapping("{performer_id}")
    public Performer getOne(@PathVariable("performer_id") Performer performer) {
        return performer;
    }

    @PostMapping
    public Performer create(@RequestBody PerformerForm form) {
        System.out.println("-------------" + form.getAddress_id());
        return performerService.add(form);
    }

    @PutMapping("{performer_id}")
    public Performer update(@PathVariable("performer_id") Long id,
                          @RequestBody PerformerForm form) {
        return performerService.update(id, form);
    }

    @DeleteMapping("{performer_id}")
    public void delete(@PathVariable("performer_id") Performer performer) {
        System.out.println("Удаление" + performer);
        performerService.delete(performer);
    }
}
