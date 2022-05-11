//package com.example.database.service.implementation;
//
//import com.example.database.api.form.TypeForm;
//import com.example.database.model.entity.Genre;
//import com.example.database.repository.TypeRepository;
//import com.example.database.utils.exception.BadRequestException;
//import com.example.database.utils.exception.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class TypeServiceImpl implements TypeService {
//
//    @Autowired
//    TypeRepository typeRepository;
//
//    @Override
//    public Genre addNewType(TypeForm typeForm) {
//        if(!StringUtils.hasText(typeForm.getName())) {
//            String mess = "Invalid argument";
//            throw new BadRequestException(mess);
//        }
//
//        Genre genre = Genre.builder()
//                .name(typeForm.getName())
//                .build();
//
//        return save(genre);
//    }
//
//    @Override
//    public Genre updateType(Long id, String name) {
//        Genre genre = typeRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(genre)) {
//            String mess = "type-not-exits";
//            throw new NotFoundException(mess);
//        }
//        genre.setName(name);
//
//        return save(genre);
//    }
//
//    @Override
//    public void deleteTpe(Long id) {
//        Genre genre = typeRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(genre)) {
//            String mess = "type-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        typeRepository.deleteById(id);
//    }
//
//    @Override
//    public Genre getById(Long id) {
//        Genre genre = typeRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(genre)) {
//            String mess = "type-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        return genre;
//    }
//
//    @Override
//    public List<Genre> getTypeList() {
//        List<Genre> genres = (List<Genre>) typeRepository.findAll();
//        if(ObjectUtils.isEmpty(genres)) {
//            return Collections.EMPTY_LIST;
//        }
//
//        return genres;
//    }
//
//    @Override
//    public Genre save(Genre genre) {
//        return typeRepository.save(genre);
//    }
//}
