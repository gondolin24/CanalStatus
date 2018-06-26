package models;


public class CanalStatus {

    private int id;
    private String status;
    private String status_type;
    private boolean valid_date;
    private String next;
    private Object subsequent;
    private int requests;
    private int bridge_id;
    private String created_at;
    private String updated_at;
    private String next_direction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    public boolean isValid_date() {
        return valid_date;
    }

    public void setValid_date(boolean valid_date) {
        this.valid_date = valid_date;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getSubsequent() {
        return subsequent;
    }

    public void setSubsequent(Object subsequent) {
        this.subsequent = subsequent;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }

    public int getBridge_id() {
        return bridge_id;
    }

    public void setBridge_id(int bridge_id) {
        this.bridge_id = bridge_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getNext_direction() {
        return next_direction;
    }

    public void setNext_direction(String next_direction) {
        this.next_direction = next_direction;
    }

    public String getSubsequent_direction() {
        return subsequent_direction;
    }

    public void setSubsequent_direction(String subsequent_direction) {
        this.subsequent_direction = subsequent_direction;
    }

    private String subsequent_direction;
}
