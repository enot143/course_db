package db.course.service;


import db.course.domain.*;
import db.course.dto.CaseDTO;
import db.course.dto.CasesDTO;
import db.course.form.CaseForm;
import db.course.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CaseService {
    @Autowired
    CaseRepo caseRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    CasePerformerRepo casePerformerRepo;
    @Autowired
    CaseSourceRepo caseSourceRepo;
    @Autowired
    PerformerRepo performerRepo;
    @Autowired
    SourceRepo sourceRepo;

    public ResponseEntity<?> findAll() {
        return getJSON();
    }

    public Case add(CaseForm form){
        Case c = new Case();
        return setCaseParameters(c, form);
    }

    //end case here
    public Case update(Integer id, CaseForm form){
        Case c = caseRepo.findCaseById(id);
//        if (form.getEnd_date() != null){
//            caseRepo.endCase(c.getId());
//        }
        return setCaseParameters(c, form);
    }

    public void delete(Case c) {
        caseRepo.delete(c);
    }

    public void endCase(Case c) {
        caseRepo.endCase(c.getId());
    }


    public void addPerformer(Case c, Performer p) {
        CasePerformerKey casePerformerKey = new CasePerformerKey();
        casePerformerKey.setCaseId(c.getId());
        casePerformerKey.setPerformerId(p.getId());
        CasePerformer casePerformer = new CasePerformer();
        casePerformer.setC(c);
        casePerformer.setPerformer(p);
        casePerformer.setId(casePerformerKey);
        casePerformerRepo.save(casePerformer);
    }


    public void addSource(Case c, Source s) {
        CaseSourceKey caseSourceKey = new CaseSourceKey();
        caseSourceKey.setCaseId(c.getId());
        caseSourceKey.setSourceId(s.getId());
        CaseSource caseSource = new CaseSource();
        caseSource.setC(c);
        caseSource.setSource(s);
        caseSource.setId(caseSourceKey);
        caseSourceRepo.save(caseSource);
    }

    @Transactional
    Case setCaseParameters(Case c, CaseForm form){
        c.setName(form.getName());
        c.setClient(clientRepo.findClientById(form.getClient_id()));
        c.setAddress(addressRepo.findAddressById(form.getAddress_id()));
        Case newCase = caseRepo.save(c);
        if (form.getPerformers() != null){
            if (form.getPerformers().size() <= 2) {
                casePerformerRepo.deleteByC_Id(c.getId());
            }
            for (int i = 0; i < form.getPerformers().size(); i++){
                this.addPerformer(c, performerRepo.findPerformerById(form.getPerformers().get(i)));
            }
        }
        if (form.getSources() != null){
            caseSourceRepo.deleteByC_Id(c.getId());
            for (int i = 0; i < form.getSources().size(); i++){
                this.addSource(c, sourceRepo.findSourceById(form.getSources().get(i)));
            }
        }
        return newCase;
    }
    //TODO:sort
    private ResponseEntity<?> getJSON(){
        ArrayList<CasesDTO> cases = new ArrayList<>();
        caseRepo.findAll().forEach(c -> {
            CasesDTO caseDTO = new CasesDTO();
            caseDTO.setId(c.getId());
            caseDTO.setAddress(c.getAddress());
            caseDTO.setClient(c.getClient());
            caseDTO.setFinish(c.getEnd_date());
            caseDTO.setStart(c.getStart_date());
            caseDTO.setCaseName(c.getName());
            cases.add(caseDTO);
        });
        return new ResponseEntity<>(cases, HttpStatus.OK);
    }

    public ResponseEntity<?> getOne(Case c) {
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setaCase(c);
        caseDTO.setListOfEvidences(caseRepo.findEvidences(c.getId()));
        caseDTO.setListOfPerformers(caseRepo.findPerformers(c.getId()));
        caseDTO.setListOfCriminals(caseRepo.findCriminals(c.getId()));
        caseDTO.setListOfSources(caseRepo.findSources(c.getId()));
        return new ResponseEntity<>(caseDTO, HttpStatus.OK);
    }
}
