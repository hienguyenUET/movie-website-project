//package com.example.database.api.controller;
//
//import com.example.database.api.form.PersonForm;
//import com.example.database.api.response.ApiResponse;
//import com.example.database.model.entity.Account;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("user/api")
//
//public class PersonController {
//    private final PersonService personService;
//
//    public PersonController(PersonService personService) {
//        this.personService = personService;
//    }
//
//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Account> addUser(@Valid @RequestBody PersonForm personForm) {
//        Account account = personService.addNewUser(personForm);
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "https://api.themoviedb.org/3/movie/550?api_key=606b350a5be7a4ff1de563e915b76a18")
//    public ResponseEntity<ApiResponse> getUserList() {
////        List<Person> people = personService.getUserList();
////        List<PersonDto> dto = people.stream().map(com.example.database.model.entity.Person::toDto).collect(Collectors.toList());
////        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các người dùng");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
////    @GetMapping(value = "/{id}")
////    public ResponseEntity<Person> getUserById(@PathVariable long id) {
////        Person person = personService.getById(id);
////        PersonDto dto = person.toDto();
////        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Người dùng %d",id));
////        return new ResponseEntity<>(person, HttpStatus.OK);
////    }
////
////    @GetMapping()
//
////    @PutMapping( "/{id}")
////    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserForm userForm, @PathVariable("id") Long id) {
////        Person person = userService.updateUser(id, userForm.getPassword(), userForm.getFilmId());
////        PersonDto dto = person.toDto();
////        ApiResponse response = ApiResponse.success(person,HttpStatus.OK.value(), "Chỉnh sửa thành công người dùng: " + userForm.getName());
////        return ResponseEntity.ok(response);
////    }
////
////    @DeleteMapping(value = "/{id}")
////    public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id) {
////        personService.deleteUser(id);
////        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công người dùng: " + id);
////        return ResponseEntity.ok(response);
////    }
//}
