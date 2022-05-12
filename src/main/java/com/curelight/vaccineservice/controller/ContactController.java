package com.curelight.vaccineservice.controller;

import com.curelight.vaccineservice.dto.Contact;
import com.curelight.vaccineservice.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contact")
public class ContactController {

    private final ContactService contactService;

    /**
     * Microsoft Teams meeting
     * Join on your computer or mobile app
     * Click here to join the meeting<https://teams.microsoft.com/l/meetup-join/19%3ameeting_ZGE1M2JmMjQtYjczMC00NTM5LTgzZjgtMDVjMmFmMzMzYTlm%40thread.v2/0?context=%7b%22Tid%22%3a%2276a2ae5a-9f00-4f6b-95ed-5d33d77c4d61%22%2c%22Oid%22%3a%2214fbb660-2787-42d2-a7a6-27acb2a7a823%22%7d>
     * Join with a video conferencing device
     * teams@vc.capgemini.com
     * Video Conference ID: 112 718 073 9
     * Alternate VTC instructions<https://vc.capgemini.com/teams/?conf=1127180739&ivr=teams&d=vc.capgemini.com&ip=194.3.231.206&prefix=55>
     * Capgemini internal video device can also connect by dialing 55+ VTC Conference ID (55XXXXXXXXXX), External users can refer to “Alternate VTC dialing instructions”
     * Learn More<https://aka.ms/JoinTeamsMeeting> | Meeting options<https://teams.microsoft.com/meetingOptions/?organizerId=14fbb660-2787-42d2-a7a6-27acb2a7a823&tenantId=76a2ae5a-9f00-4f6b-95ed-5d33d77c4d61&threadId=19_meeting_ZGE1M2JmMjQtYjczMC00NTM5LTgzZjgtMDVjMmFmMzMzYTlm@thread.v2&messageId=0&language=en-US>
     * ________________________________________________________________________________
     * @param contactService
     */

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

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public Contact getContactByEmailId(@RequestParam(required = false) String emailId,
                                       @RequestParam(required = false) String phone){
        if(StringUtils.hasLength(emailId)){
            return contactService.findContactByEmailId(emailId);
        }else if(StringUtils.hasLength(phone)){
            return contactService.findByPhoneNumber(phone);
        }
        return null;
    }


}
