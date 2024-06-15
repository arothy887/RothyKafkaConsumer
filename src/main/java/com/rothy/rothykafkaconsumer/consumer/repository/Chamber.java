package com.rothy.rothykafkaconsumer.consumer.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "chamber")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chamber {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @Column(name = "time")
    @Builder.Default
    private LocalTime time = LocalTime.now();

    @Column(name = "chamber_type", unique = true)
    private String chamberType;
    @Column(name = "high")
    private Integer high; // 0, 1
    @Column(name = "middle")
    private Integer middle;
    @Column(name = "low")
    private Integer low;

}
