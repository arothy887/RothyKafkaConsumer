package com.rothy.rothykafkaconsumer.consumer.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id")
    private Message message;

    @Column(name = "chamber_type")
    private String chamberType;
    @Column(name = "high")
    private Integer high; // 0, 1
    @Column(name = "middle")
    private Integer middle;
    @Column(name = "low")
    private Integer low;

}
