package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.factories;


import org.springframework.stereotype.Service;
import com.dennisoconnell.javamicroservicedemo.trades.domain.Party;
import com.dennisoconnell.javamicroservicedemo.trades.domain.Security;
import com.dennisoconnell.javamicroservicedemo.trades.domain.Trade;
import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos.PartyDto;
import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos.SecurityDto;
import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos.TradeDto;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TradeDtoFactory {

    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    public List<TradeDto> compute(List<Trade> trades){
        return trades.stream().map(t ->
                TradeDto
                .builder()
                .id(t.getId())
                .price(t.getPrice())
                .status(t.getStatus())
                .executionId(t.getExecutionId())
                .orderId(t.getOrderId())
                .tradeType(t.getTradeType())
                .buySell(t.getBuySell())
                .currency(t.getCurrency())
                .tradedSecurity(computeSecurityDto(t.getTradedSecurity()))
                .buyerId(computePartyDto(t.getParty()))

                //.buyerId(computePartyDto(t.getBuyer()))
                //.sellerId(computePartyDto(t.getSeller()))
                .executionTime( DATE_FORMAT.format(t.getExecutionTime()))
                .build())
                .collect(Collectors.toList());
    }

    public SecurityDto computeSecurityDto(Security security){
        return SecurityDto.builder()
                .id(security.getId())
                .ticker(security.getTicker())
                .currency(security.getCurrency())
                .cusip(security.getCusip())
                .build();
    }

    public PartyDto computePartyDto(Party party){
        return PartyDto.builder()
                .id(party.getId())
                .name(party.getName())
                .currnency(party.getCurrnency())
                .partyType(party.getPartyType())
                .build();
    }
}

