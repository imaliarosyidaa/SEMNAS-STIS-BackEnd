package com.semnasstis.SemnasSTIS.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String participantID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Event> events;
}
