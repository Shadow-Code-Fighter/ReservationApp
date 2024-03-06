package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_routes")
public class SubRoutes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private  Long id;
    private String routeFrom;
    private String routeTo;
    private Integer distance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bus bus;
}
