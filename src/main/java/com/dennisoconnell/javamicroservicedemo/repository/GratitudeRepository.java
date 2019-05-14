package com.dennisoconnell.javamicroservicedemo.repository;

import com.dennisoconnell.javamicroservicedemo.models.Gratitude;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.Future;

@Repository
public interface GratitudeRepository extends JpaRepository<Gratitude,Integer> {


    @Async
    Future<List<Gratitude>> findByCategoryAsync(String Category);

}
