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
@EqualsAndHashCode
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String ticker;

    public String cusip;

    public String currency;

    @OneToMany(mappedBy = "tradedSecurity", cascade = CascadeType.ALL)
    private Set<Trade> trades;


    @Column(name = "created_on", nullable = false)
    public Date CreatedOn;


    @Column(name = "update_at", nullable = false)
    public Date UpdateAt;

}
