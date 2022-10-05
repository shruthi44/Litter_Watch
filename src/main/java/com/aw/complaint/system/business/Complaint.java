package com.aw.complaint.system.business;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private String description;
    @Column(name="LASTUPDATEDDATETIME")
    private LocalDateTime currentDateTime;

    private String status ="Submitted";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCurrentDateTime() {
        currentDateTime =LocalDateTime.now();
        return currentDateTime;
    }


    public Complaint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Complaint(String place, String description) {
        this.place = place;
        this.description = description;

    }

}
