package com.rothy.rothykafkaconsumer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamberRepository extends JpaRepository<Chamber, Integer> {
}
