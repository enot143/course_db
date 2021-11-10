package db.course.dto;

import db.course.domain.Suspect;

public class EvidenceDTO {
    private Long id;
    private String name;
    private String caseName;
    private String suspect;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect.getHuman().getName() + " " + suspect.getHuman().getSurname();
    }
}
