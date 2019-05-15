package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.sql;

import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.file.TradeFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeSeeder {

    @Autowired
    public TradeFileReader tradeFileReader;

    @Autowired
    public TradeDataProxy tradeDataProxy;

    public void seedTradeData() throws Exception {

    }
}
