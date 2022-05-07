package com.curelight.vaccineservice.controller;

import com.curelight.vaccineservice.dto.Contact;
import com.curelight.vaccineservice.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public Contact getContactById(@PathVariable Long id){
        return contactService.findContact(id);
    }

    @PostMapping()
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }

    @PutMapping(value = "/{id}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable Long id){
        return contactService.updateContact(contact, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }

    @GetMapping(value = "/emailId/{emailId}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public Contact getContactByEmailId(@PathVariable String  emailId){
        return contactService.findContactByEmailId(emailId);
    }


}
