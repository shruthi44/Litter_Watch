package com.example.major.project;

public class Complaint {
    private Long id;
    private String place;
    private String description;

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

    public Complaint(Long id, String place, String description) {
        this.id = id;
        this.place = place;
        this.description = description;
    }

}
