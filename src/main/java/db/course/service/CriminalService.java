package db.course.service;

import db.course.domain.Criminal;
import db.course.dto.CriminalDTO;
import db.course.form.CriminalForm;
import db.course.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


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


    public ResponseEntity<?> findAll() {
        return getJSON();
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
    private ResponseEntity<?> getJSON(){
        ArrayList<CriminalDTO> criminals = new ArrayList<>();
        criminalRepo.findAll().forEach(criminal -> {
            CriminalDTO criminalDTO = new CriminalDTO();
            criminalDTO.setId(criminal.getId());
            criminalDTO.setCrimeType(criminal.getCrimeType().getName());
            criminalDTO.setName(criminal.getHuman());
            criminalDTO.setPunishmentName(criminal.getPunishment().getName());
            criminalDTO.setPunishmentLasting(criminal.getPunishment().getLasting());
            criminalDTO.setaCase(criminal.getC().getName());
            criminals.add(criminalDTO);
        });
        return new ResponseEntity<>(criminals, HttpStatus.OK);
    }
}
