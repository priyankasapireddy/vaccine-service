package com.curelight.vaccineservice.service;

public abstract class AbstractEmailIdVerifier implements EmailIdVerifier {

    @Override
    public boolean isValidEmail(String emailId) {
        // call the common DNS server to verify the email id valid or not
        return false;
    }
}
