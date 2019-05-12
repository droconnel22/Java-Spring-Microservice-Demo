package com.dennisoconnell.javamicroservicedemo.models;


import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class HelloDto {

    public HelloDto() {
        gratitudes = new ArrayList<>();
    }

    @NotNull
    public String name;

    @NotNull
    public Integer helloId;
    public List<GratitudeDto> gratitudes;
    public String createdTimestamp;

}
