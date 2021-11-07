package db.course.form;

public class CriminalForm {
    private Long human_id;
    private Long crimeType_id;
    private Long punishment_id;
    private Integer case_id;

    public Long getHuman_id() {
        return human_id;
    }

    public void setHuman_id(Long human_id) {
        this.human_id = human_id;
    }

    public Long getCrimeType_id() {
        return crimeType_id;
    }

    public void setCrimeType_id(Long crimeType_id) {
        this.crimeType_id = crimeType_id;
    }

    public Long getPunishment_id() {
        return punishment_id;
    }

    public void setPunishment_id(Long punishment_id) {
        this.punishment_id = punishment_id;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }
}
