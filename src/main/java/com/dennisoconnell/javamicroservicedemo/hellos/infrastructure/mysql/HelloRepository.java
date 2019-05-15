package com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql;

import com.dennisoconnell.javamicroservicedemo.hellos.domain.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HelloRepository extends JpaRepository<Hello,Integer> {

    List<Hello> findByName(final String Name);

}
