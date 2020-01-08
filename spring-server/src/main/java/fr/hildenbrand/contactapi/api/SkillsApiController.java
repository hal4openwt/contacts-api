package fr.hildenbrand.contactapi.api;

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
public class SkillsApiController implements SkillsApi {

	@Autowired
	SkillRepository skillRepository;
	
    private static final Logger log = LoggerFactory.getLogger(SkillsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SkillsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addSkill(@ApiParam(value = "Skill object that needs to be added" ,required=true )  @Valid @RequestBody Skill body) {
        try {
        	body.setId(null);
        	skillRepository.save(body);
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        catch(Exception e) {
        	log.error("Server exception: ", e);
        	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteSkill(@ApiParam(value = "Skill ID to delete",required=true) @PathVariable("skillId") Long skillId) {
    	try {
        	Skill skill = skillRepository.findOne(skillId);
        	if (skill==null)
        		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        	else {
        		skillRepository.delete(skillId);
        		return new ResponseEntity<Void>(HttpStatus.OK);
        	}
        }
        catch(Exception e) {
        	log.error("Server exception: ", e);
        	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Skill> getSkillById(@ApiParam(value = "ID of skill to return",required=true) @PathVariable("skillId") Long skillId) {
    	try {
        	Skill skill = skillRepository.findOne(skillId);
        	if (skill==null)
        		return new ResponseEntity<Skill>(HttpStatus.NOT_FOUND);
        	else {
        		return new ResponseEntity<Skill>(skill,HttpStatus.OK);
        	}
        }
        catch(Exception e) {
        	log.error("Server exception: ", e);
        	return new ResponseEntity<Skill>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Skill>> listSkills() {
    	try {
        	List<Skill> skills = (List<Skill>)skillRepository.findAll();
        	return new ResponseEntity<List<Skill>>(skills,HttpStatus.OK);
        }
        catch(Exception e) {
        	log.error("Server exception: ", e);
        	return new ResponseEntity<List<Skill>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<Void> updateSkill(@ApiParam(value = "ID of skill to return",required=true) @PathVariable("skillId") Long skillId,@ApiParam(value = "Skill that needs to be updated" ,required=true )  @Valid @RequestBody Skill body) {
    	try {
        	Skill skill = skillRepository.findOne(skillId);
        	if (skill==null)
        		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        	else {
        		body.setId(skillId);
        		skillRepository.save(body);
        		return new ResponseEntity<Void>(HttpStatus.OK);
        	}
        }
        catch(Exception e) {
        	log.error("Server exception: ", e);
        	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
