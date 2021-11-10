package db.course.controller;

import db.course.domain.Criminal;
import db.course.form.CriminalForm;
import db.course.service.CriminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminal")
public class CriminalController {
    @Autowired
    private final CriminalService criminalService;

    public CriminalController(CriminalService criminalService) {
        this.criminalService = criminalService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return criminalService.findAll();
    }


    @GetMapping("{criminal_id}")
    public Criminal getOne(@PathVariable("criminal_id") Criminal c) {
        return c;
    }

    @PostMapping
    public Criminal create(@RequestBody CriminalForm form) {
        return criminalService.add(form);
    }

    @PutMapping("{criminal_id}")
    public Criminal update(@PathVariable("criminal_id") Long id,
                       @RequestBody CriminalForm form) {
        return criminalService.update(id, form);
    }

    @DeleteMapping("{criminal_id}")
    public void delete(@PathVariable("criminal_id") Criminal c) {
        criminalService.delete(c);
    }
}
