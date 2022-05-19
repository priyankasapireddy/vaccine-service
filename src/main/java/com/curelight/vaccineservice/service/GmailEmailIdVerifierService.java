package com.curelight.vaccineservice.service;

import com.curelight.vaccineservice.dto.EmailDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GmailEmailIdVerifierService extends AbstractEmailIdVerifier implements EmailIdVerifier{



    @Override
    public EmailDetails getEmailDetails(String emailId) {
        return null;
    }
}
