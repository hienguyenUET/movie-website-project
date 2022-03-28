package com.example.database.api.controller;


import com.example.database.api.form.TypeForm;
import com.example.database.api.response.ApiResponse;
import com.example.database.model.dto.TypeDto;
import com.example.database.model.entity.Type;
import com.example.database.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("type/api")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping
    public ResponseEntity<ApiResponse> addType(@RequestBody TypeForm typeForm) {
        Type type = typeService.addNewType(typeForm);
        TypeDto dto = type.toDto();
        ApiResponse response = ApiResponse.success(type, HttpStatus.OK.value(), "Thêm thể loại thành công");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getTypeList() {
        List<Type> types = typeService.getTypeList();
        List<TypeDto> dto = types.stream().map(Type::toDto).collect(Collectors.toList());
        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các thể loại");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTypeById(@PathVariable long id) {
        Type type = typeService.getById(id);
        TypeDto dto = type.toDto();
        ApiResponse response = ApiResponse.success(type,HttpStatus.OK.value(), String.format("Thể loại %d",id));
        return ResponseEntity.ok(response);
    }

    @PutMapping( "/{id}")
    public ResponseEntity<ApiResponse> updateType(@RequestBody TypeForm typeForm, @PathVariable("id") Long id) {
        Type type = typeService.updateType(id, typeForm.getName());
        TypeDto dto = type.toDto();
        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), "Chỉnh sửa thành công thể loại: " + typeForm.getName());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteType(@PathVariable long id) {
        typeService.deleteTpe(id);
        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công thể loại: " + id);
        return ResponseEntity.ok(response);
    }
}
