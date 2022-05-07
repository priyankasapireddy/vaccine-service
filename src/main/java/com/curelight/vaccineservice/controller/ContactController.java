package com.curelight.vaccineservice.controller;

import com.curelight.vaccineservice.dto.Contact;
import com.curelight.vaccineservice.service.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Contact getContactById(@PathVariable Long id){
        return contactService.findContact(id);
    }

    @PostMapping()
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }
}
