package db.course.form;

import db.course.domain.Performer;

import java.sql.Date;
import java.util.ArrayList;

public class CaseForm {
    private Long client_id;
    private Long address_id;
    private String name;
    private Date end_date;
    private ArrayList<Long> performers;

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Long> getPerformers() {
        return performers;
    }

    public void setPerformers(ArrayList<Long> performers) {
        this.performers = performers;
    }
}
