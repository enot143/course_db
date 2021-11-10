package db.course.dto;

import db.course.domain.Client;

public class ClientDTO {
    private Long id;
    private boolean police;
    private Long money;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPolice() {
        return police;
    }

    public void setPolice(boolean police) {
        this.police = police;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(Client client) {
        this.name = client.getHuman().getName() + " " + client.getHuman().getSurname();
    }
}
