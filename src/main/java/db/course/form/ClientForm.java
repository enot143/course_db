package db.course.form;

public class ClientForm {
    private boolean police;
    private Long cash;
    private Long human_id;

    public boolean isPolice() {
        return police;
    }

    public void setPolice(boolean police) {
        this.police = police;
    }

    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }

    public Long getHuman_id() {
        return human_id;
    }

    public void setHuman_id(Long human_id) {
        this.human_id = human_id;
    }
}
