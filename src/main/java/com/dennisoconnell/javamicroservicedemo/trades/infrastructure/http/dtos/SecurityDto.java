package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityDto {

    public long id;

    public String ticker;

    public String cusip;

    public String currency;

}
