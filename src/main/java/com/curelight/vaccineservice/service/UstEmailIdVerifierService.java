package com.curelight.vaccineservice.service;

import com.curelight.vaccineservice.dto.EmailDetails;
import org.springframework.stereotype.Component;

@Component
public class UstEmailIdVerifierService extends AbstractEmailIdVerifier implements EmailIdVerifier{
    @Override
    public EmailDetails getEmailDetails(String emailId) {
        return null;
    }
}
