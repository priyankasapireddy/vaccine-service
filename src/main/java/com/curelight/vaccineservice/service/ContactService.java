package com.curelight.vaccineservice.service;

import com.curelight.vaccineservice.dto.Contact;
import com.curelight.vaccineservice.entity.ContactEntity;
import com.curelight.vaccineservice.exception.NoContactFoundException;
import com.curelight.vaccineservice.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ObjectMapper mapper;

    public ContactService(ContactRepository contactRepository, ObjectMapper mapper) {
        this.contactRepository = contactRepository;
        this.mapper = mapper;
    }

    public Contact findContact(Long id){
        Optional<ContactEntity> optionalContactEntity = contactRepository.findById(id);
        if(optionalContactEntity.isPresent()){
            return mapper.convertValue(optionalContactEntity.get(), Contact.class);
        }else {
            throw  new NoContactFoundException(id )  ;
        }
    }

    public Contact createContact(Contact contact){
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

}
