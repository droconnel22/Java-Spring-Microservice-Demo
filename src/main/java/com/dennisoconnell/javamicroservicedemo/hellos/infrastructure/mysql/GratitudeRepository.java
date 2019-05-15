package com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql;

import com.dennisoconnell.javamicroservicedemo.hellos.domain.Gratitude;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GratitudeRepository extends JpaRepository<Gratitude,Integer> {


    List<Gratitude> findByCategory(String Category);

}
