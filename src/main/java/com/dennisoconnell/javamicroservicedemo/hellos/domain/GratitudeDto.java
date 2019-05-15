package com.dennisoconnell.javamicroservicedemo.hellos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class GratitudeDto {

    @NotNull
    public Integer gratitudeId;

    @NotNull
    public String category;

    @NotNull
    @Max(500)
    @Min(2)
    public String title;

    @NotNull
    public String reason;
    public String createdOn;
}
