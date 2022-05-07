package com.curelight.vaccineservice.service;

import com.curelight.vaccineservice.dto.Contact;
import com.curelight.vaccineservice.entity.ContactEntity;
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
        Optional<ContactEntity> contactEntity = contactRepository.findById(id);
        if(contactEntity.isPresent()){
            return mapper.convertValue(contactEntity.get(), Contact.class);
        }else {
            return null;
        }
    }

    public Contact createContact(Contact contact){
        ContactEntity savedEntity = contactRepository.save(mapper.convertValue(contact, ContactEntity.class));
        return mapper.convertValue(savedEntity, Contact.class);
    }


}
