package db.course.service;


import db.course.domain.Case;
import db.course.dto.CaseDTO;
import db.course.form.CaseForm;
import db.course.repos.AddressRepo;
import db.course.repos.CaseRepo;
import db.course.repos.ClientRepo;
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
        if (form.getEnd_date() != null){
            caseRepo.endCase(c.getId());
        }
        return setCaseParameters(c, form);
    }

    public void delete(Case c) {
        caseRepo.delete(c);
    }

    public void endCase(Case c) {
        caseRepo.endCase(c.getId());
    }

    @Transactional
    Case setCaseParameters(Case c, CaseForm form){
        c.setName(form.getName());
        c.setClient(clientRepo.findClientById(form.getClient_id()));
        c.setAddress(addressRepo.findAddressById(form.getAddress_id()));
        return caseRepo.save(c);
    }
    //TODO:sort
    private ResponseEntity<?> getJSON(){
        ArrayList<CaseDTO> cases = new ArrayList<>();
        caseRepo.findAll().forEach(c -> {
            CaseDTO caseDTO = new CaseDTO();
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
}
