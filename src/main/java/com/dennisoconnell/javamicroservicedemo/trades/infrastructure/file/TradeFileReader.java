package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.file;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


@Service
public class TradeFileReader {

    private static final Logger log = LoggerFactory.getLogger(TradeFileReader.class);

    //@Value(value = "classpath:input/tradefile.csv")
    //private Resource tradeFileCSV;
}
