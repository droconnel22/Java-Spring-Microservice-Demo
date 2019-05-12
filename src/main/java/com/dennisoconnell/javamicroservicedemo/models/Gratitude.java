package com.dennisoconnell.javamicroservicedemo.models;



import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "GratitudeList")
public class Gratitude {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer Id;


    public String category;
    public String Title;
    public String Reason;
    public Date CreatedOn;

    @ManyToOne
    @JoinColumn

    public Hello Hello;


    public Gratitude(String category, String title, String reason, Hello hello) {
        this.category = category;
        Title = title;
        Reason = reason;
        CreatedOn = new Date();
        this.Hello = hello;
    }

    public Gratitude(Integer Id, String category, String title, String reason) {
        this.Id  = Id;
        this.category = category;
        Title = title;
        Reason = reason;
        CreatedOn = new Date();
    }

    public Gratitude(Integer Id, String category, String title, String reason, Date createdOn) {
        this.Id  = Id;
        this.category = category;
        Title = title;
        Reason = reason;
        this.CreatedOn = createdOn;
    }

    public Gratitude(Integer Id, String category, String title, String reason, Hello hello) {
        this.Id  = Id;
        this.category = category;
        Title = title;
        Reason = reason;
        CreatedOn = new Date();
        this.Hello = hello;
    }


    public GratitudeDto toDto() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        GratitudeDto gratitudeDto = new GratitudeDto();
        gratitudeDto.category = this.category;
        gratitudeDto.reason = this.Reason;
        gratitudeDto.title = this.Title;
        gratitudeDto.gratitudeId = this.Id;
        gratitudeDto.createdOn = DATE_FORMAT.format(this.CreatedOn);
        return gratitudeDto;
    }



}
