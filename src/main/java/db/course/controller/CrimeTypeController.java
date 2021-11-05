package db.course.controller;


import db.course.domain.CrimeType;
import db.course.repos.CrimeTypeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crimetype")
public class CrimeTypeController {
    private final CrimeTypeRepo crimeTypeRepo;

    @Autowired
    public CrimeTypeController(CrimeTypeRepo crimeTypeRepo) {
        this.crimeTypeRepo = crimeTypeRepo;
    }

    @GetMapping
    public List<CrimeType> list() {
        return crimeTypeRepo.findAll();
    }

    @GetMapping("{crimetype_id}")
    public CrimeType getOne(@PathVariable("crimetype_id") CrimeType crimeType) {
        return crimeType;
    }

    @PostMapping
    public CrimeType create(@RequestBody CrimeType crimeType){
        return crimeTypeRepo.save(crimeType);
    }

    @PutMapping("{crimetype_id}")
    public CrimeType update(@PathVariable("crimetype_id") CrimeType crimeTypeFromDb,
                         @RequestBody CrimeType crimeType) {
        BeanUtils.copyProperties(crimeType, crimeTypeFromDb, "crimetype_id");
        return crimeTypeRepo.save(crimeTypeFromDb);
    }

    @DeleteMapping("{crimetype_id}")
    public void delete(@PathVariable("crimetype_id") CrimeType crimeType) {
        crimeTypeRepo.delete(crimeType);
    }
}
