package db.course.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of = {"human_id", "name", "surname", "age", "gender", "profession"})
@EqualsAndHashCode(of = {"human_id"})
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long human_id;
    private String name;
    private String surname;
    private Long age;
    private boolean gender;
    private String profession;

    public Long getHuman_id() {
        return human_id;
    }

    public void setHuman_id(Long human_id) {
        this.human_id = human_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
