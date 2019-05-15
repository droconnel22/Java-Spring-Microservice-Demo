package com.dennisoconnell.javamicroservicedemo.trades.infrastructure.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dennisoconnell.javamicroservicedemo.trades.domain.Trade;


@Repository
public interface TradeDataProxy extends JpaRepository<Trade,Long> {

}
