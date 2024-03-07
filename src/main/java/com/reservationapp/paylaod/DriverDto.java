package com.reservationapp.paylaod;

import lombok.Data;

@Data
public class DriverDto {
    private long id;
    private String name;
    private String licenseNumber;
    private String adharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String email;
    private String busNumber;
//    private String busType;
}
