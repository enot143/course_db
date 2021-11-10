package db.course.dto;

import db.course.domain.Address;
import db.course.domain.Client;

import java.sql.Date;

public class CaseDTO {
    private Integer id;
    private String client;
    private String address;
    private String caseName;
    private Date start;
    private Date finish;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client.getHuman().getName() + " " + client.getHuman().getSurname();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address.getCity() + ", " + address.getStreet() + ", " + address.getHouse();
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }
}
