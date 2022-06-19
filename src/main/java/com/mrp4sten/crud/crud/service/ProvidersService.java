package com.mrp4sten.crud.crud.service;

import java.util.List;

import com.mrp4sten.crud.crud.dto.ProviderDto;

public interface ProvidersService {
    List<ProviderDto> list();
    Boolean add(ProviderDto provider);
    Boolean update(String id, ProviderDto provider);
    Boolean delete(String id);

}
