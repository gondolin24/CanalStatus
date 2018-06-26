package models;


public class CanalData {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getCanal_id() {
        return canal_id;
    }

    public void setCanal_id(int canal_id) {
        this.canal_id = canal_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Object getClosures() {
        return closures;
    }

    public void setClosures(Object closures) {
        this.closures = closures;
    }

    public CanalStatus getStatus() {
        return status;
    }

    public void setStatus(CanalStatus status) {
        this.status = status;
    }

    private int id;
    private int order;
    private int canal_id;
    private String name;
    private String nickname;
    private String location;
    private String created_at;
    private String updated_at;
    private Object closures;
    private CanalStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
