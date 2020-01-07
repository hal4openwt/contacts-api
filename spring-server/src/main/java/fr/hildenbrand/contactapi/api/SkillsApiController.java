package fr.hildenbrand.contactapi.api;

import fr.hildenbrand.contactapi.model.Contact;
import fr.hildenbrand.contactapi.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-07T11:22:56.790+01:00")

@Controller
public class SkillsApiController implements SkillsApi {

    private static final Logger log = LoggerFactory.getLogger(SkillsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SkillsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addSkill(@ApiParam(value = "Skill object that needs to be added" ,required=true )  @Valid @RequestBody Skill body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteSkill(@ApiParam(value = "Skill ID to delete",required=true) @PathVariable("skillId") Long skillId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Contact> getSkillById(@ApiParam(value = "ID of skill to return",required=true) @PathVariable("skillId") Long skillId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Contact>(objectMapper.readValue("{  \"skills\" : [ {    \"level\" : \"very good\",    \"name\" : \"name\",    \"id\" : 6  }, {    \"level\" : \"very good\",    \"name\" : \"name\",    \"id\" : 6  } ],  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"mobilePhoneNumber\" : \"mobilePhoneNumber\",  \"address\" : \"address\",  \"fullName\" : \"fullName\",  \"id\" : 0,  \"email\" : \"email\"}", Contact.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Contact>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Contact>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Skill>> listSkills() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Skill>>(objectMapper.readValue("[ {  \"level\" : \"very good\",  \"name\" : \"name\",  \"id\" : 6}, {  \"level\" : \"very good\",  \"name\" : \"name\",  \"id\" : 6} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Skill>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Skill>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateSkill(@ApiParam(value = "Skill that needs to be updated" ,required=true )  @Valid @RequestBody Skill body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
