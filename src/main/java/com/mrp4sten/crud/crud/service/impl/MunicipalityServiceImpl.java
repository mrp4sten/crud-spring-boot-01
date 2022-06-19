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
import com.mrp4sten.crud.crud.dto.MunicipalityDto;
import com.mrp4sten.crud.crud.firebase.FirebaseInitializer;
import com.mrp4sten.crud.crud.service.MunicipalitiesService;

@Service
public class MunicipalityServiceImpl implements MunicipalitiesService{

    @Autowired FirebaseInitializer firebase;

    @Override
    public List<MunicipalityDto> list() {
        List<MunicipalityDto> response = new ArrayList<>();
        MunicipalityDto municipality;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                municipality = doc.toObject(MunicipalityDto.class);
                municipality.setId(doc.getId());
                response.add(municipality);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public Boolean add(MunicipalityDto municipality) {
        Map<String, Object> docData = getDocData(municipality);

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
    public Boolean update(String id, MunicipalityDto municipality) {
        Map<String, Object> docData = getDocData(municipality);
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
        return firebase.getFireStore().collection("municipality");
    }

    private Map<String, Object> getDocData(MunicipalityDto municipality) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("municipalityName", municipality.getMunicipalityName());
        docData.put("entityName", municipality.getEntityName());
        return docData;
    }
    
}
