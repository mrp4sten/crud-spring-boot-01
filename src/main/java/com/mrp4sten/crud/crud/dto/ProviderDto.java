package com.mrp4sten.crud.crud.dto;

import lombok.Data;

@Data
public class ProviderDto {
    private String id;
    private String rfc;
    private String bussinesName;
    private String contactName;
    private String street;
    private Long interiorNumber;
    private Long externalNumber;
    private String suburb;
    private String location;
    private String entity;
    private String municipality;
    private String country;
    private Long postalCode;
    private String email;
    private Long phoneNumber;
    private String status;
}
