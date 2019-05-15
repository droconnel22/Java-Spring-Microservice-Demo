package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dennisoconnell.javamicroservicedemo.trades.domain.Trade;
import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.dtos.TradeDto;
import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.http.factories.TradeDtoFactory;
import com.dennisoconnell.javamicroservicedemo.trades.service.TradeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/")
public class TradeController {

    private static final Logger log = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    public TradeService tradeService;


    @GetMapping(value = "com/dennisoconnell/javamicroservicedemo/trades")
    public ResponseEntity<List<TradeDto>> getTrades(){

        List<Trade> trades = tradeService.findAllTrades();

        //List<TradeDto> tradeDtos = tradeDtoFactory.compute(trades);

        return  new ResponseEntity<>(new ArrayList<TradeDto>(), HttpStatus.OK);
    }
}

