package db.course.service;

import db.course.domain.Evidence;
import db.course.dto.EvidenceDTO;
import db.course.form.EvidenceForm;
import db.course.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class EvidenceService {
    @Autowired
    CaseRepo caseRepo;
    @Autowired
    EvidenceRepo evidenceRepo;
    @Autowired
    SuspectRepo suspectRepo;

    public ResponseEntity<?> findAll() {
        return getJSON();
    }

    public Evidence add(EvidenceForm form){
        Evidence evidence = new Evidence();
        return setEvidenceParameters(evidence, form);
    }


    public Evidence update(Long id, EvidenceForm form){
        Evidence evidence =  evidenceRepo.findEvidenceById(id);
        return setEvidenceParameters(evidence, form);
    }

    public void delete(Evidence evidence) {
        evidenceRepo.delete(evidence);
    }


    @Transactional
    Evidence setEvidenceParameters(Evidence e, EvidenceForm form){
        e.setEvid_name(form.getEvid_name());
        e.setSuspect(suspectRepo.findSuspectById(form.getSuspect_id()));
        e.setC(caseRepo.findCaseById(form.getCase_id()));
        return evidenceRepo.save(e);
    }
    private ResponseEntity<?> getJSON(){
        ArrayList<EvidenceDTO> evidences = new ArrayList<>();
        evidenceRepo.findAll().forEach(e -> {
            EvidenceDTO evidenceDTO = new EvidenceDTO();
            evidenceDTO.setId(e.getId());
            evidenceDTO.setCaseName(e.getC().getName());
            evidenceDTO.setName(e.getEvid_name());
            evidenceDTO.setSuspect(e.getSuspect());
            evidences.add(evidenceDTO);
        });
        return new ResponseEntity<>(evidences, HttpStatus.OK);
    }
}
