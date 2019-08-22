package jsontest.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity


public class User {


    @Id
    private String phone;
    private String id;
    private String name;
    private String place;
    private String email;
    private String designation;
    private String fa_code;
    private String fa_expire_time;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFa_code() {
        return fa_code;
    }

    public void setFa_code(String fa_code) {
        this.fa_code = fa_code;
    }

    public String getFa_expire_time() {
        return fa_expire_time;
    }

    public void setFa_expire_time(String fa_expire_time) {
        this.fa_expire_time = fa_expire_time;
    }
}
