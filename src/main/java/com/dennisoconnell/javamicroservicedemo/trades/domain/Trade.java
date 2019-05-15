package com.dennisoconnell.javamicroservicedemo.trades.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Trade {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public double price;

    public String status;

    public String executionId;

    public String orderId;

    // market, stop, stop-market, bid
    public String tradeType;

    public String buySell;

    public String currency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "security")
    @JsonIgnore
    private Security tradedSecurity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    public Party Party;


    public Date executionTime;

    @Column(name = "created_on", nullable = false)
    public Date CreatedOn;


    @Column(name = "update_at", nullable = false)
    public Date UpdateAt;


}
