package db.course.service;


import db.course.domain.Suspect;
import db.course.form.SuspectForm;
import db.course.repos.HumanRepo;
import db.course.repos.SuspectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuspectService {
    @Autowired
    SuspectRepo suspectRepo;
    @Autowired
    HumanRepo humanRepo;

    public List<Suspect> findAll() {
        return suspectRepo.findAll();
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


}
