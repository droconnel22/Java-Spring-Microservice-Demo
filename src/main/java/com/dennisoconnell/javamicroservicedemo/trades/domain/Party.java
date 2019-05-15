package com.dennisoconnell.javamicroservicedemo.trades.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String name;

    public String currnency;

    public String partyType;


    @OneToMany(mappedBy = "Party", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Trade> Trades;


    @Column(name = "created_on", nullable = false)
    public Date CreatedOn;


    @Column(name = "update_at", nullable = false)
    public Date UpdateAt;
}
