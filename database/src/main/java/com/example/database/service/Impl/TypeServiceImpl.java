package com.example.database.service.Impl;

import com.example.database.api.form.TypeForm;
import com.example.database.model.entity.Type;
import com.example.database.repository.TypeRepository;
import com.example.database.service.TypeService;
import com.example.database.utils.exception.BadRequestException;
import com.example.database.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    public Type addNewType(TypeForm typeForm) {
        if(!StringUtils.hasText(typeForm.getName())) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

        Type type = Type.builder()
                .name(typeForm.getName())
                .build();

        return save(type);
    }

    @Override
    public Type updateType(Long id, String name) {
        Type type = typeRepository.findById(id).get();
        if(ObjectUtils.isEmpty(type)) {
            String mess = "type-not-exits";
            throw new NotFoundException(mess);
        }
        type.setName(name);

        return save(type);
    }

    @Override
    public void deleteTpe(Long id) {
        Type type = typeRepository.findById(id).get();
        if(ObjectUtils.isEmpty(type)) {
            String mess = "type-not-exits";
            throw new NotFoundException(mess);
        }

        typeRepository.deleteById(id);
    }

    @Override
    public Type getById(Long id) {
        Type type = typeRepository.findById(id).get();
        if(ObjectUtils.isEmpty(type)) {
            String mess = "type-not-exits";
            throw new NotFoundException(mess);
        }

        return type;
    }

    @Override
    public List<Type> getTypeList() {
        List<Type> types = (List<Type>) typeRepository.findAll();
        if(ObjectUtils.isEmpty(types)) {
            return Collections.EMPTY_LIST;
        }

        return types;
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }
}
