package db.course.service;

import db.course.domain.Human;
import db.course.repos.HumanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HumanService {
    @Autowired
    private HumanRepo humanRepo;
    
    public HumanService(HumanRepo humanRepo) {
        this.humanRepo = humanRepo;
    }
    public Human loadHumanByName(String name) throws UsernameNotFoundException {
        return humanRepo.findByName(name);
    }
}