package db.course.dto;

import db.course.domain.Human;

public class SuspectDTO {
    private Long id;
    private String name;
    private String appearance;
    private boolean is_criminal;

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

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public boolean isIs_criminal() {
        return is_criminal;
    }

    public void setIs_criminal(boolean is_criminal) {
        this.is_criminal = is_criminal;
    }
}
