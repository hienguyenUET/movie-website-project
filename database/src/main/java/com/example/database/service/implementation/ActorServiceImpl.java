//package com.example.database.service.Impl;
//
//import com.example.database.api.form.ActorForm;
//import com.example.database.repository.ActorRepository;
//import com.example.database.repository.FilmRepository;
//import com.example.database.service.ActorService;
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
//public class ActorServiceImpl implements ActorService {
//
//    @Autowired
//    ActorRepository actorRepository;
//
//    @Autowired
//    FilmRepository filmRepository;
//
////    @Override
////    public Actor addNewActor(ActorForm actorForm) {
////        // check xem có bỏ trống tên hay không
////        if(!StringUtils.hasText(actorForm.getName())) {
////            String mess = "Invalid argument";
////            throw new BadRequestException(mess);
////        }
////
////        Actor actor = Actor.builder()
////                .name(actorForm.getName())
////                .build();
////
////        return save(actor);
////    }
//
//    @Override
//    public Actor updateActor(Long id, String name, List<Long> filmId) {
//        Actor actor = actorRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(actor)) {
//            String mess = "actor-not-exits";
//            throw new NotFoundException(mess);
//        }
//        actor.setName(name);
//
//        if(filmId == null) {
//            return save(actor);
//        } else {
//            filmId.forEach(item -> {
//                int dem = (int) actor.getMovies().stream().filter(film -> item == film.getId()).count();
//                if(dem == 0) {
//                    actor.getMovies().add(filmRepository.findById(item).get());
//                }
//            });
//
//            return save(actor);
//        }
//    }
//
//    @Override
//    public void deleteActor(Long id) {
//        Actor actor = actorRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(actor)) {
//            String mess = "actor-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        actorRepository.deleteById(id);
//    }
//
//    @Override
//    public Actor getById(Long id) {
//        Actor actor = actorRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(actor)) {
//            String mess = "actor-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        return actor;
//    }
//
//    @Override
//    public List<Actor> getActorList() {
//        List<Actor> actors = (List<Actor>) actorRepository.findAll();
//        if(ObjectUtils.isEmpty(actors)) {
//            return Collections.EMPTY_LIST;
//        }
//
//        return actors;
//    }
//
//    @Override
//    public Actor save(Actor actor) {
//        return actorRepository.save(actor);
//    }
//}
