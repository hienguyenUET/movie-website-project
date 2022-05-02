//package com.example.database.service.Impl;
//
//import com.example.database.api.form.PersonForm;
//import com.example.database.model.entity.Account;
//import com.example.database.repository.MovieRepository;
//import com.example.database.repository.PersonRepository;
//import com.example.database.service.PersonService;
//import com.example.database.utils.exception.NotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class PersonServiceImpl implements PersonService {
//    private final PersonRepository personRepository;
//
//    private final MovieRepository movieRepository;
//
//    public PersonServiceImpl(PersonRepository personRepository, MovieRepository movieRepository) {
//        this.personRepository = personRepository;
//        this.movieRepository = movieRepository;
//    }
//
//    @Override
//    public Account addNewUser(PersonForm personForm) {
////        String afterEncrypted = PasswordEncoder.encode(personForm.getPassword());
//
//        Account account = Account.builder()
//                .username(personForm.getUsername())
//                .name(personForm.getName())
//                .password(personForm.getPassword())
//                .email(personForm.getEmail())
//                .build();
//        return save(account);
//    }
//
////    @Override
////    public Account updateUser(Long id, String password, List<Long> filmId) {
////        Account account = personRepository.findById(id).get();
////        if(ObjectUtils.isEmpty(account)) {
////            String mess = "user-not-exits";
////            throw new NotFoundException(mess);
////        }
////        account.setPassword(password);
////
////        if(filmId == null) {
////            return save(account);
////        } else {
////            filmId.forEach(item -> {
////                int dem = (int) account.getMovies().stream().filter(film -> item == film.getId()).count();
////                if(dem == 0) {
////                    account.getMovies().add(movieRepository.findById(item).get());
////                }
////            });
////
////            return save(account);
////        }
////    }
//
//    @Override
//    public void deleteUser(Long id) {
//        Account account = personRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(account)) {
//            String mess = "user-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        personRepository.deleteById(id);
//    }
//
//    @Override
//    public Account getById(Long id) {
//        Account account = personRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(account)) {
//            String mess = "user-not-exits";
//            throw new NotFoundException(mess);
//        }
//        return account;
//    }
//
//    @Override
//    public List<Account> getUserList() {
//        List<Account> people = (List<Account>) personRepository.findAll();
//        if(ObjectUtils.isEmpty(people)) {
//            return Collections.EMPTY_LIST;
//        }
//
//        return people;
//    }
//
//    @Override
//    public Account save(Account account) {
//        return personRepository.save(account);
//    }
//}
