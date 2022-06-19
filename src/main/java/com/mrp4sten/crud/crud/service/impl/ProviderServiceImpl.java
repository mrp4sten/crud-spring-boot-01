package com.mrp4sten.crud.crud.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.mrp4sten.crud.crud.dto.ProviderDto;
import com.mrp4sten.crud.crud.firebase.FirebaseInitializer;
import com.mrp4sten.crud.crud.service.ProvidersService;

@Service
public class ProviderServiceImpl implements ProvidersService{

    @Autowired FirebaseInitializer firebase;
    
    @Override
    public List<ProviderDto> list() {
        List<ProviderDto> response = new ArrayList<>();
        ProviderDto provider;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                provider = doc.toObject(ProviderDto.class);
                provider.setId(doc.getId());
                response.add(provider);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public Boolean add(ProviderDto provider) {
        Map<String, Object> docData = getDocData(provider);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            if (writeResultApiFuture != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean update(String id, ProviderDto provider) {
        Map<String, Object> docData = getDocData(provider);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return Boolean.FALSE;
        }
    }

    private CollectionReference getCollection() {
        return firebase.getFireStore().collection("provider");
    }

    private Map<String, Object> getDocData(ProviderDto provider) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("rfc", provider.getRfc());
        docData.put("bussinesName", provider.getBussinesName());
        docData.put("contactName", provider.getContactName());
        docData.put("street", provider.getStreet());
        docData.put("interiorNumber", provider.getInteriorNumber());
        docData.put("externalNumber", provider.getExternalNumber());
        docData.put("suburb", provider.getSuburb());
        docData.put("location", provider.getLocation());
        docData.put("entity", provider.getEntity());
        docData.put("municipality", provider.getMunicipality());
        docData.put("country", provider.getCountry());
        docData.put("postalCode", provider.getPostalCode());
        docData.put("email", provider.getEmail());
        docData.put("phoneNumber", provider.getPhoneNumber());
        docData.put("status", provider.getStatus());
        return docData;
    }
    
}
