package db.course.dto;

import db.course.domain.Human;

import java.sql.Date;

public class CriminalDTO {
    private Long id;
    private String name;
    private String crimeType;
    private String punishmentName;
    private Date punishmentLasting;
    private String aCase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(Human human) {
        this.name = human.getName() + " " + human.getSurname();
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getPunishmentName() {
        return punishmentName;
    }

    public void setPunishmentName(String punishmentName) {
        this.punishmentName = punishmentName;
    }

    public Date getPunishmentLasting() {
        return punishmentLasting;
    }

    public void setPunishmentLasting(Date punishmentLasting) {
        this.punishmentLasting = punishmentLasting;
    }

    public String getaCase() {
        return aCase;
    }

    public void setaCase(String aCase) {
        this.aCase = aCase;
    }
}
