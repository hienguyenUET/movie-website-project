package com.example.database.api.form;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Form for creating new user
 * username: username để đăng ký tài khoản
 * password: mật khẩu
 * name: tên người dùng
 * email: email người dùng
 */

@Setter
@Getter
@Builder
public class AccountForm {

    @NotNull(message = "Value cannot be null")
    @Size(min = 6, message = "Username must be longer than 6 characters")
    private String username;

    @NotNull(message = "Value cannot be null")
    private String name;

    @NotNull(message = "Value cannot be null")
    @Size(min = 6, message = "Password must be longer than 6 characters")
    private String password;

    @NotNull(message = "Value cannot be null")
    @Email
    private String email;
//    private List<Long> filmId;
}
