package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PartyDto {

    public long id;

    public String name;

    public String currnency;

    public String partyType;

}
