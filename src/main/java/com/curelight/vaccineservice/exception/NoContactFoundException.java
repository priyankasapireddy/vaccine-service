package com.curelight.vaccineservice.exception;

public class NoContactFoundException extends RuntimeException{
    public NoContactFoundException(Long id) {
        super("No contact found with id "+id);
    }
}
