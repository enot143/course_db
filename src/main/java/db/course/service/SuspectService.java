package db.course.service;


import db.course.domain.Suspect;
import db.course.dto.SuspectDTO;
import db.course.form.SuspectForm;
import db.course.repos.HumanRepo;
import db.course.repos.SuspectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuspectService {
    @Autowired
    SuspectRepo suspectRepo;
    @Autowired
    HumanRepo humanRepo;

    public ResponseEntity<?> findAll() {
        return getJSON();
    }

    public Suspect add(SuspectForm form){
        Suspect suspect = new Suspect();
        return setSuspectParameters(suspect, form);
    }

    public Suspect update(Long id, SuspectForm form){
        Suspect suspect = suspectRepo.findSuspectById(id);
        return setSuspectParameters(suspect, form);
    }

    public void delete(Suspect suspect) {
        suspectRepo.delete(suspect);
    }

    private Suspect setSuspectParameters(Suspect suspect, SuspectForm form){
        suspect.setAppearance(form.getAppearance());
        suspect.setHuman(humanRepo.findHumanById(form.getHuman_id()));
        return suspectRepo.save(suspect);
    }

    private ResponseEntity<?> getJSON(){
        ArrayList<SuspectDTO> suspects = new ArrayList<>();
        suspectRepo.findAll().forEach(s -> {
            SuspectDTO suspectDTO = new SuspectDTO();
            suspectDTO.setId(s.getId());
            suspectDTO.setAppearance(s.getAppearance());
            suspectDTO.setIs_criminal(s.isCriminal());
            suspectDTO.setName(s.getHuman());
            suspects.add(suspectDTO);
        });
        return new ResponseEntity<>(suspects, HttpStatus.OK);
    }
}
