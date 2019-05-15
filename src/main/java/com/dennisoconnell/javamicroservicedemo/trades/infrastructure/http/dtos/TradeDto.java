package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TradeDto {

    public long id;

    public double price;

    public String status;

    public String executionId;

    public String orderId;

    // market, stop, stop-market, bid
    public String tradeType;

    public String buySell;

    public String currency;

    private SecurityDto tradedSecurity;

    public PartyDto buyerId;

    public PartyDto sellerId;

    public String executionTime;

}
