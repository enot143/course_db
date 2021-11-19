package db.course.controller;

import db.course.domain.Evidence;
import db.course.form.EvidenceForm;
import db.course.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("evidence")
public class EvidenceController {
    @Autowired
    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return evidenceService.findAll();
    }

    @GetMapping("{evidence_id}")
    public Evidence getOne(@PathVariable("evidence_id") Evidence evidence) {
        return evidence;
    }

    @PostMapping
    public Evidence create(@RequestBody EvidenceForm form) {
        return evidenceService.add(form);
    }

    @PutMapping("{evidence_id}")
    public Evidence update(@PathVariable("evidence_id") Long id,
                          @RequestBody EvidenceForm form) {
        return evidenceService.update(id, form);
    }

    @DeleteMapping("{evidence_id}")
    public void delete(@PathVariable("evidence_id") Evidence evidence) {
        evidenceService.delete(evidence);
    }
}
