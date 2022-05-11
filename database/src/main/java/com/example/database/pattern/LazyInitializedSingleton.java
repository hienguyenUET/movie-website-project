package com.example.database.pattern;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    private int id;
    private String username;
    private String email;
    private String role;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
