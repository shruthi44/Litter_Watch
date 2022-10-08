package com.aw.complaint.system.business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private boolean admin;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "client")
    private List<Complaint> complaints = new ArrayList<>();

    public Client() {
    }

    public Client(String firstName, String lastName, String emailId, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
        complaint.setClient(this);
    }

    public long getLastComplaint() {
        return complaints.get(complaints.size()-1).getId();
    }
}
