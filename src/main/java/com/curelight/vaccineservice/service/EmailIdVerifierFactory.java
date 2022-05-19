package com.curelight.vaccineservice.service;

import org.springframework.stereotype.Component;

@Component
public class EmailIdVerifierFactory {

    EmailIdVerifier gmailEmailIdVerifierService;
    EmailIdVerifier ustEmailIdVerifierService;

    public EmailIdVerifier getVerifier(String emailId){
        String domain = getEmailDomain(emailId);
        if(domain.equalsIgnoreCase("gmail")){
            return gmailEmailIdVerifierService;
        }else {
            return ustEmailIdVerifierService;
        }
    }

    private String getEmailDomain(String emailId){
        String secondPart = emailId.split("@")[1];
        String domain = secondPart.split(".")[0];
        return domain;
    }
}
