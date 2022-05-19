package com.curelight.vaccineservice.service;

import com.curelight.vaccineservice.dto.Contact;
import com.curelight.vaccineservice.dto.Vaccine;
import com.curelight.vaccineservice.dto.VaccineList;
import com.curelight.vaccineservice.entity.ContactEntity;
import com.curelight.vaccineservice.exception.NoContactFoundException;
import com.curelight.vaccineservice.repository.ContactRepository;
import com.curelight.vaccineservice.validator.EmailIdValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final EmailIdValidator emailIdValidator;
    private final EmailIdVerifierFactory emailIdVerifierFactory;
    private final ObjectMapper mapper;
    private final RestTemplate restTemplate;

    public ContactService(ContactRepository contactRepository, EmailIdValidator emailIdValidator, EmailIdVerifierFactory emailIdVerifierFactory, ObjectMapper mapper, RestTemplate restTemplate) {
        this.contactRepository = contactRepository;
        this.emailIdValidator = emailIdValidator;
        this.emailIdVerifierFactory = emailIdVerifierFactory;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    public Contact findContact(Long id){

//        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = "https://api.us.castlighthealth.com/vaccine-finder/v1/medications?category=covid";
        ResponseEntity<Vaccine[]> response = restTemplate.getForEntity(fooResourceUrl, Vaccine[].class);

        Vaccine[] vaccines = response.getBody();

        Optional<ContactEntity> optionalContactEntity = contactRepository.findById(id);
        if(optionalContactEntity.isPresent()){
            return mapper.convertValue(optionalContactEntity.get(), Contact.class);
        }else {
            throw  new NoContactFoundException(id )  ;
        }
    }

    public Contact createContact(Contact contact){
        // verify if the contact is valid or not
        boolean validEmail = emailIdValidator.validateEmail(contact.getEmailId());
        if(!validEmail){
            throw new RuntimeException("Invalid Email");
        }

        boolean isValedEmailFromExternalParty = emailIdVerifierFactory.getVerifier(contact.getEmailId()).isValidEmail(contact.getEmailId());
        if(!isValedEmailFromExternalParty){
            throw new RuntimeException("Invalid Email");
        }

        ContactEntity savedEntity = contactRepository.save(mapper.convertValue(contact, ContactEntity.class));
        return mapper.convertValue(savedEntity, Contact.class);
    }

    public Contact updateContact(Contact contact, Long id){
        Optional<ContactEntity> optionalContactEntity = contactRepository.findById(id);
        if(optionalContactEntity.isPresent()){
            ContactEntity entity = optionalContactEntity.get();
            entity.setName(contact.getName());
            entity.setPhoneNumber(contact.getPhoneNumber());
            entity.setGender(contact.getGender());
            entity.setEmailId(contact.getEmailId());
            ContactEntity savedEntity = contactRepository.save(entity);
            return mapper.convertValue(savedEntity, Contact.class);
        }else {
            throw new NoContactFoundException(id);
        }
    }

    public void deleteContact(Long id){
        contactRepository.deleteById(id);
    }



    public Contact findContactByEmailId(String  emailId){
        Optional<ContactEntity> optionalContactEntity = contactRepository.findByEmailIdEquals(emailId);
        if(optionalContactEntity.isPresent()){
            return mapper.convertValue(optionalContactEntity.get(), Contact.class);
        }else {
            throw  new NoContactFoundException(1L )  ;
        }
    }

    public Contact findByPhoneNumber(String phone) {
        Optional<ContactEntity> optionalContactEntity = contactRepository.findByPhoneNumber(phone);
        if(optionalContactEntity.isPresent()){
            return mapper.convertValue(optionalContactEntity.get(), Contact.class);
        }else {
            throw  new NoContactFoundException(1L )  ;
        }
    }


}
