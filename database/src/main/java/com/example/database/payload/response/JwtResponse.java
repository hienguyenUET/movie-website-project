package com.example.database.payload.response;

import com.example.database.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private final String TYPE = "Bearer";
    private int id;
    private String username;
    private String email;
    private String role;
}
