package OnBoardApp.Checklist.model;

import javax.persistence.*;

@Entity
@Table(name="Checklist")
public class user {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long id;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="MobileNo")
    private long mobileNo;
    @Column(name="Email")
    private String email;
    @Column(name="Place")
    private String place;
    @Column(name="Designation")
    private String designation;
    @Column(name="Checklist")
    private String checklist;

    public user(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", place='" + place + '\'' +
                ", designation='" + designation + '\'' +
                ", checklist='" + checklist + '\'' +
                '}';
    }
}
