package com.mrp4sten.crud.crud.service;

import java.util.List;

import com.mrp4sten.crud.crud.dto.MunicipalityDto;

public interface MunicipalitiesService {
    List<MunicipalityDto> list();
    Boolean add(MunicipalityDto municipality);
    Boolean update(String id, MunicipalityDto municipality);
    Boolean delete(String id);
}
