package db.course.service;


import db.course.domain.Case;
import db.course.form.CaseForm;
import db.course.repos.AddressRepo;
import db.course.repos.CaseRepo;
import db.course.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaseService {
    @Autowired
    CaseRepo caseRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    ClientRepo clientRepo;

    public List<Case> findAll() {
        return caseRepo.findAll();
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


    @Transactional
    Case setCaseParameters(Case c, CaseForm form){
        c.setName(form.getName());
        c.setClient(clientRepo.findClientById(form.getClient_id()));
        c.setAddress(addressRepo.findAddressById(form.getAddress_id()));
        return caseRepo.save(c);
    }
}
