package db.course.controller;

import db.course.domain.Source;
import db.course.repos.SourceRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("source")
public class SourceController {
    private final SourceRepo sourceRepo;

    @Autowired
    public SourceController(SourceRepo sourceRepo) {
        this.sourceRepo = sourceRepo;
    }

    @GetMapping
    public List<Source> list() {
        return sourceRepo.findAll();
    }

    @GetMapping("{source_id}")
    public Source getOne(@PathVariable("source_id") Source source) {
        return source;
    }

    @PostMapping
    public Source create(@RequestBody Source source){
        return sourceRepo.save(source);
    }

    @PutMapping("{source_id}")
    public Source update(@PathVariable("source_id") Source sourceFromDb,
                          @RequestBody Source source) {
        BeanUtils.copyProperties(source, sourceFromDb, "source_id");
        return sourceRepo.save(sourceFromDb);
    }

    @DeleteMapping("{source_id}")
    public void delete(@PathVariable("source_id") Source source) {
        sourceRepo.delete(source);
    }
}
