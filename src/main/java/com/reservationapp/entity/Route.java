package com.reservationapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private  Long id;
    private String routeFrom;
    private String routeTo;
    private Integer distance;

    @JsonIgnore
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Bus> busList = new ArrayList<>();
}
