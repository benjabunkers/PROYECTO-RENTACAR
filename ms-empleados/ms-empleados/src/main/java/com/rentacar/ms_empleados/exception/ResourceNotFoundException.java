package com.rentacar.ms_empleados.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {

        super(message);
    }
}
