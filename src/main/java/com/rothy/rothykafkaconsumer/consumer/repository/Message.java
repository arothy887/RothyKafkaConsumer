package com.rothy.rothykafkaconsumer.consumer.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name = "message")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "message")
    private List<Chamber> chambers;

}
