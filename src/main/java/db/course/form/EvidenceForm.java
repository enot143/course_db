package db.course.form;

public class EvidenceForm {
    private Long suspect_id;
    private Integer case_id;
    private String evid_name;

    public Long getSuspect_id() {
        return suspect_id;
    }

    public void setSuspect_id(Long suspect_id) {
        this.suspect_id = suspect_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public String getEvid_name() {
        return evid_name;
    }

    public void setEvid_name(String evid_name) {
        this.evid_name = evid_name;
    }
}
