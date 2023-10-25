package com.semnasstis.SemnasSTIS.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long orderID;
     @Column(nullable = false)
     private String purchase;
     @ManyToOne
     @JoinColumn(name="id")
     private Event eventID;
     @ManyToOne
     @JoinColumn(name="participantID")
     private Participant participantID;
     @Column(nullable = false)
     @CreationTimestamp
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
     private Date created_time;
}
