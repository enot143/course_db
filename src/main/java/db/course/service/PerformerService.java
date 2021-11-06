package db.course.service;

import db.course.domain.Performer;
import db.course.form.PerformerForm;
import db.course.repos.AddressRepo;
import db.course.repos.HumanRepo;
import db.course.repos.PerformerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerService {
    @Autowired
    PerformerRepo performerRepo;
    @Autowired
    HumanRepo humanRepo;
    @Autowired
    AddressRepo addressRepo;

    public List<Performer> findAll() {
        return performerRepo.findAll();
    }

    public Performer add(PerformerForm form){
        Performer performer = new Performer();
        return setPerformerParameters(performer, form);
    }

    public Performer update(Long id, PerformerForm form){
        Performer performer = performerRepo.findPerformerById(id);
        return setPerformerParameters(performer, form);
    }

    public void delete(Performer performer) {
        performerRepo.delete(performer);
    }

    private Performer setPerformerParameters(Performer performer, PerformerForm form){
        performer.setHuman(humanRepo.findHumanById(form.getHuman_id()));
        performer.setAddress(addressRepo.findAddressById(form.getAddress_id()));
        return performerRepo.save(performer);
    }
}
