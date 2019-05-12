package com.dennisoconnell.javamicroservicedemo.repository;

import com.dennisoconnell.javamicroservicedemo.models.Gratitude;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GratitudeRepository extends JpaRepository<Gratitude,Integer> {


    List<Gratitude> findByCategory(final String Category);

}
