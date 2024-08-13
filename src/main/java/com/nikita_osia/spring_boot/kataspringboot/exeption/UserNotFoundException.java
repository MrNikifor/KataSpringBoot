package com.nikita_osia.spring_boot.kataspringboot.exeption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String massage){
        super(massage);
    }
}
