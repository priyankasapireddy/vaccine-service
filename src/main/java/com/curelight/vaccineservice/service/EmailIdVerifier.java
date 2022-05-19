package com.curelight.vaccineservice.service;

import com.curelight.vaccineservice.dto.EmailDetails;

public interface EmailIdVerifier {

    /**
     *  Interface
     *  abstract class
     *  factory pattern
     *  Dynamic binding
     *  polumarphism
     *  what is the bean name that is created by default by spring
     *
     *
     *
     *
     */
    boolean isValidEmail(String emailId);

    EmailDetails getEmailDetails(String emailId);
}
