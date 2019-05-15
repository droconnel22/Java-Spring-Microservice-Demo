package com.dennisoconnell.javamicroservicedemo.trades.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dennisoconnell.javamicroservicedemo.trades.domain.Trade;
import com.dennisoconnell.javamicroservicedemo.trades.domain.TradeRepository;
import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.sql.TradeDataProxy;

import java.util.ArrayList;
import java.util.List;


@Service
public class TradeService {


    @Autowired
    public TradeDataProxy tradeDataProxy;

    public TradeRepository tradeRepository;

    private static final Logger log = LoggerFactory.getLogger(TradeService.class);

    public void TradeService(){

        this.tradeRepository = new TradeRepository(new ArrayList<Trade>());

    }

    public List<Trade> findAllTrades(){
        refreshCache();
        return tradeRepository.getAll();
    }


    private void refreshCache(){

        long dbSize = this.tradeDataProxy.count();

        if(tradeRepository.getCount() != dbSize){
            List<Trade> trades = this.tradeDataProxy.findAll();
            tradeRepository = new TradeRepository(trades);
        }
    }

}

