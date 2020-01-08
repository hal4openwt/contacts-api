package fr.hildenbrand.contactapi.api;

import fr.hildenbrand.contactapi.dbaccess.ContactRepository;
import fr.hildenbrand.contactapi.dbaccess.SkillRepository;
import fr.hildenbrand.contactapi.model.Contact;
import fr.hildenbrand.contactapi.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-08T11:20:11.645+01:00")

@Controller
public class ContactsApiController implements ContactsApi {

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	private static final Logger log = LoggerFactory.getLogger(ContactsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContactsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addContact(@ApiParam(value = "Contact object that needs to be added" ,required=true )  @Valid @RequestBody Contact body) {
        try {
        	body.setId(null);
        	contactRepository.save(body);
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        } 
        catch(Exception e) {
    		log.error("Server exception: ", e);
    		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @Transactional
    public ResponseEntity<Void> addSkillToContact(@ApiParam(value = "ID of contact to update",required=true) @PathVariable("contactId") Long contactId,@ApiParam(value = "ID of skill to add" ,required=true )  @Valid @RequestBody Skill skill) {
    	try {
	        Skill skillInDB = skillRepository.findOne(skill.getId());
	        if (skillInDB==null) {
	        	return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
	        }
	        
	        Contact contactInDB = contactRepository.findOne(contactId);
	        if (contactInDB==null) {
	        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
	        }
	        
	        contactInDB.getSkills().add(skillInDB);
	        contactRepository.save(contactInDB);
	        
	        return new ResponseEntity<Void>(HttpStatus.OK);
    	} 
    	catch(Exception e) {
    		log.error("Server exception: ", e);
    		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @Transactional
    public ResponseEntity<Void> deleteContact(@ApiParam(value = "Contact id to delete",required=true) @PathVariable("contactId") Long contactId) {
    	try {
    		Contact contact=contactRepository.findOne(contactId);
    		if (contact==null)
    			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    		else {
    			contactRepository.delete(contactId);
    			return new ResponseEntity<Void>(HttpStatus.OK);
    		}
        } 
    	catch (Exception e) {
            log.error("Server exception: ", e);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Contact> getContactById(@ApiParam(value = "ID of contact to return",required=true) @PathVariable("contactId") Long contactId) {
    	try {
    		Contact contact=contactRepository.findOne(contactId);
    		if (contact==null)
    			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
    		else
    			return new ResponseEntity<Contact>(contact,HttpStatus.OK);
    	} 
    	catch(Exception e) {
    		log.error("Server exception: ", e);
    		return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    public ResponseEntity<List<Contact>> listContacts() {
    	try {
        	return new ResponseEntity<List<Contact>>((List<Contact>)contactRepository.findAll(),HttpStatus.OK);
    	} 
    	catch(Exception e) {
    		log.error("Server exception: ", e);
    		return new ResponseEntity<List<Contact>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @Transactional
    public ResponseEntity<Void> updateContact(@ApiParam(value = "ID of contact to return",required=true) @PathVariable("contactId") Long contactId,@ApiParam(value = "Contact object that needs to be updated" ,required=true )  @Valid @RequestBody Contact body) {
    	try {
    		Contact contact=contactRepository.findOne(contactId);
    		if (contact==null)
    			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    		else {
    			contact.setId(contactId);
    			contactRepository.save(body);
    			return new ResponseEntity<Void>(HttpStatus.OK);
    		}
    	}
    	catch(Exception e) {
    		log.error("Server exception: ", e);
    		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

}
