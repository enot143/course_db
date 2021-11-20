package db.course.controller;

import db.course.domain.Case;
import db.course.domain.Performer;
import db.course.domain.Source;
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
    public ResponseEntity<?> getOne(@PathVariable("case_id") Case c) {
        return caseService.getOne(c);
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

    @GetMapping("performer/{case_id}/{performer_id}")
    public void addPerformer(@PathVariable("case_id") Case c, @PathVariable("performer_id")Performer p){
        caseService.addPerformer(c, p);
    }

    @GetMapping("source/{case_id}/{source_id}")
    public void addSource(@PathVariable("case_id") Case c, @PathVariable("source_id") Source s){
        caseService.addSource(c, s);
    }

    @DeleteMapping("{case_id}")
    public void delete(@PathVariable("case_id") Case c) {
        caseService.delete(c);
    }
}
