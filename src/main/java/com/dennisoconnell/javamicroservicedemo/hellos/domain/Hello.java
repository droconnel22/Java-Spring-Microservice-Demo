package com.dennisoconnell.javamicroservicedemo.hellos.domain;


import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Hello {


    public String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false)
    public Date CreatedOn;

    @OneToMany(mappedBy = "Hello", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Gratitude> GratitudeList;



    public Hello(String name) {
        this.name = name;
        CreatedOn = new Date();
        GratitudeList = new ArrayList<>();
    }

    public void AddGratitude(Gratitude gratitude){
        GratitudeList.add(gratitude);
    }

    public  String Sayhello(){
        return String.format("Hello s ! Your Id Number is %d and the date is %s", name, Id, CreatedOn);
    }

    public HelloDto toDto(){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        HelloDto helloDto = new HelloDto();
        helloDto.name = this.getName();
        helloDto.helloId = this.getId();
        helloDto.createdTimestamp = DATE_FORMAT.format(this.getCreatedOn());
        for(Gratitude gratitude : this.GratitudeList){
            helloDto.gratitudes.add(gratitude.toDto());
        }
        return helloDto;
    }
}
