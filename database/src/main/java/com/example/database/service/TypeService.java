package com.example.database.service;

import com.example.database.api.form.TypeForm;
import com.example.database.model.entity.Type;

import java.util.List;

public interface TypeService {
    Type addNewType(TypeForm typeForm);

    Type updateType(Long id, String name);

    void deleteTpe(Long id);

    Type getById(Long id);

    List<Type> getTypeList();

    Type save(Type type);
}
