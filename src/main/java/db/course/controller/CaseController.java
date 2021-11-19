package db.course.controller;

import db.course.domain.Case;
import db.course.form.CaseForm;
import db.course.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("case")
public class CaseController {
    @Autowired
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return caseService.findAll();
    }

    //TODO: list of evidences, criminals, performers
    @GetMapping("{case_id}")
    public Case getOne(@PathVariable("case_id") Case c) {
        return c;
    }

    @PostMapping
    public Case create(@RequestBody CaseForm form) {
        return caseService.add(form);
    }

    @PutMapping("{case_id}")
    public Case update(@PathVariable("case_id") Integer id,
                         @RequestBody CaseForm form) {
        return caseService.update(id, form);
    }
    @GetMapping("end/{case_id}")
    public void endCase(@PathVariable("case_id") Case c){
        caseService.endCase(c);
    }

    @DeleteMapping("{case_id}")
    public void delete(@PathVariable("case_id") Case c) {
        caseService.delete(c);
    }
}
