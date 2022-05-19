package com.curelight.vaccineservice.validator;

import org.springframework.stereotype.Component;

@Component
public class EmailIdValidator {

    public boolean validateEmail(String emailId){
        if(null == emailId || emailId.length() ==0){
            return false;
        };
        if(!emailId.contains("@")){
            return false;
        }
        if(!emailId.contains(".")){
            return false;
        }
        if(emailId.split("@").length > 2){
            return false;
        }
        if(emailId.split(".").length > 2){
            return false;
        }
        return true;
    }
}
