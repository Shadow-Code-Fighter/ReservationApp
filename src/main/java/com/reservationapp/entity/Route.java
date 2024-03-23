package com.reservationapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotNull(message = "Start point cannot be null !")
    @NotBlank(message = "Start point cannot be blank !")
    @NotEmpty(message = "Start point cannot be empty !")
    private String routeFrom;

    @NotNull(message = "Destination point cannot be null !")
    @NotBlank(message = "Destination point cannot be blank !")
    @NotEmpty(message = "Destination point cannot be empty !")
    private String routeTo;

    @DateTimeFormat(pattern = "dd-HH-yyyy")
    private String fromDate;

    @DateTimeFormat(pattern = "dd-HH-yyyy")
    private String toDate;
    private Integer distance;

    @JsonIgnore
    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Bus> busList = new ArrayList<>();

}
