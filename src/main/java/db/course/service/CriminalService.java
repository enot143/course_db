package db.course.service;

import db.course.domain.Criminal;
import db.course.form.CriminalForm;
import db.course.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CriminalService {
    @Autowired
    CriminalRepo criminalRepo;
    @Autowired
    CaseRepo caseRepo;
    @Autowired
    HumanRepo humanRepo;
    @Autowired
    CrimeTypeRepo crimeTypeRepo;
    @Autowired
    PunishmentRepo punishmentRepo;


    public List<Criminal> findAll() {
        return criminalRepo.findAll();
    }

    public Criminal add(CriminalForm form){
        Criminal c = new Criminal();
        return setCaseParameters(c, form);
    }


    public Criminal update(Long id, CriminalForm form){
        Criminal criminal =  criminalRepo.findCriminalById(id);
        return setCaseParameters(criminal, form);
    }

    public void delete(Criminal c) {
        criminalRepo.delete(c);
    }


    @Transactional
    Criminal setCaseParameters(Criminal c, CriminalForm form){
        c.setHuman(humanRepo.findHumanById(form.getHuman_id()));
        c.setCrimeType(crimeTypeRepo.findCrimeTypeById(form.getCrimeType_id()));
        c.setPunishment(punishmentRepo.findPunishmentById(form.getPunishment_id()));
        c.setC(caseRepo.findCaseById(form.getCase_id()));
        System.out.println(c);
        return criminalRepo.save(c);
    }
}
