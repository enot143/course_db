package db.course.controller;

import db.course.domain.Punishment;
import db.course.repos.PunishmentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("punishment")
public class PunishmentController {
    private final PunishmentRepo punishmentRepo;

    @Autowired
    public PunishmentController(PunishmentRepo punishmentRepo) {
        this.punishmentRepo = punishmentRepo;
    }

    @GetMapping
    public List<Punishment> list() {
        return punishmentRepo.findAll();
    }

    @GetMapping("{punishment_id}")
    public Punishment getOne(@PathVariable("punishment_id") Punishment punishment) {
        return punishment;
    }

    @PostMapping
    public Punishment create(@RequestBody Punishment punishment){
        return punishmentRepo.save(punishment);
    }

    @PutMapping("{punishment_id}")
    public Punishment update(@PathVariable("punishment_id") Punishment punishmentFromDb,
                         @RequestBody Punishment punishment) {
        BeanUtils.copyProperties(punishment, punishmentFromDb, "punishment_id");
        return punishmentRepo.save(punishmentFromDb);
    }

    @DeleteMapping("{punishment_id}")
    public void delete(@PathVariable("punishment_id") Punishment punishment) {
        punishmentRepo.delete(punishment);
    }
}
