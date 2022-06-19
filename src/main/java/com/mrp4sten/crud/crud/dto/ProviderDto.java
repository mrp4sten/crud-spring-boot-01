package com.mrp4sten.crud.crud.dto;

import lombok.Data;

@Data
public class ProviderDto {
    private String id;
    private String rfc;
    private String bussinessName;
    private String contactName;
    private String street;
    private int interiorNumber;
    private int externalNumber;
    private String suburb;
    private String location;
    private String entity;
    private String municipality;
    private String country;
    private int postalCode;
    private String email;
    private int phoneNumber;
    private String status;
}
