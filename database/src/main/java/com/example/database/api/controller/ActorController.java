//package com.example.database.api.controller;
//
//import com.example.database.api.form.ActorForm;
//import com.example.database.api.response.ApiResponse;
//import com.example.database.model.dto.ActorDto;
//import com.example.database.service.ActorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("actor/api")
//public class ActorController {
//    @Autowired
//    private ActorService actorService;
//
//    @PostMapping
//    public ResponseEntity<ApiResponse> addActor(@RequestBody ActorForm actorForm) {
//        Actor actor = actorService.addNewActor(actorForm);
//        ActorDto dto = actor.toDto();
//        ApiResponse response = ApiResponse.success(actor, HttpStatus.OK.value(), "Thêm diễn viên thành công");
//        return ResponseEntity.ok(response);
//    }
//
////    @GetMapping
////    public ResponseEntity<ApiResponse> getActorList() {
////        List<Actor> actors = actorService.getActorList();
////        List<ActorDto> dto = actors.stream().map(Actor::toDto).collect(Collectors.toList());
////        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các diễn viên");
////        return ResponseEntity.ok(response);
////    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse> getActorById(@PathVariable long id) {
//        Actor actor = actorService.getById(id);
//        ActorDto dto = actor.toDto();
//        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Diễn viên %d",id));
//        return ResponseEntity.ok(response);
//    }
//
////    @PutMapping( "/{id}")
////    public ResponseEntity<ApiResponse> updateActor(@RequestBody ActorForm actorForm, @PathVariable("id") Long id) {
////        Actor actor = actorService.updateActor(id, actorForm.getName(), actorForm.getFilmId());
////        ActorDto dto = actor.toDto();
////        ApiResponse response = ApiResponse.success(actor,HttpStatus.OK.value(), "Chỉnh sửa thành công diễn viên: " + actorForm.getName());
////        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse> deleteActor(@PathVariable long id) {
//        actorService.deleteActor(id);
//        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công diễn viên: " + id);
//        return ResponseEntity.ok(response);
//    }
//}
