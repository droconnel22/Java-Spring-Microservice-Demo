package com.dennisoconnell.javamicroservicedemo.trades.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class TradeRepository {
    private HashMap<Long,Trade> tradeCache;

    public TradeRepository(List<Trade> trades) {
        this.tradeCache = new HashMap<>();
        this.tradeCache.putAll(trades.stream().collect(Collectors.toMap(t -> t.getId(), t -> t)));
    }

    public boolean containsTradeId(long tradeId){
        return this.tradeCache.containsKey(tradeId);
    }

    public Trade getByid(long tradeId){
        return this.tradeCache.getOrDefault(tradeId, null);
    }

    public int getCount(){
        return this.tradeCache.size();
    }

    public List<Trade> getAll(){
        return new ArrayList<>(this.tradeCache.values());
    }
}


