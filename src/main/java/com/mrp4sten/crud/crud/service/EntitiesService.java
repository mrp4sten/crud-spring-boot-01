package com.mrp4sten.crud.crud.service;

import java.util.List;

import com.mrp4sten.crud.crud.dto.EntityDto;

public interface EntitiesService {
    List<EntityDto> list();
    Boolean add(EntityDto entity);
    Boolean update(String id, EntityDto entity);
    Boolean delete(String id);
}
