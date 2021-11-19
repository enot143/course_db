package db.course.controller;

import db.course.domain.Suspect;
import db.course.form.SuspectForm;
import db.course.service.SuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("suspect")
public class SuspectController {
    @Autowired
    private final SuspectService suspectService;

    public SuspectController(SuspectService suspectService) {
        this.suspectService = suspectService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return suspectService.findAll();
    }

    @GetMapping("{suspect_id}")
    public Suspect getOne(@PathVariable("suspect_id") Suspect suspect) {
        return suspect;
    }

    @PostMapping
    public Suspect create(@RequestBody SuspectForm form) {
        return suspectService.add(form);
    }

    @PutMapping("{suspect_id}")
    public Suspect update(@PathVariable("suspect_id") Long id,
                         @RequestBody SuspectForm form) {
        return suspectService.update(id, form);
    }

    @DeleteMapping("{suspect_id}")
    public void delete(@PathVariable("suspect_id") Suspect suspect) {
        suspectService.delete(suspect);
    }
}
