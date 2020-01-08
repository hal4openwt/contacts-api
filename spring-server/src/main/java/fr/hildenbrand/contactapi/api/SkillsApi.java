/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package fr.hildenbrand.contactapi.api;

import fr.hildenbrand.contactapi.model.Contact;
import fr.hildenbrand.contactapi.model.Skill;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-07T11:22:56.790+01:00")

@Api(value = "skills", description = "the skills API")
public interface SkillsApi {

    @ApiOperation(value = "Add a skill", nickname = "addSkill", notes = "", tags={ "skills", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/skills",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addSkill(@ApiParam(value = "Skill object that needs to be added" ,required=true )  @Valid @RequestBody Skill body);


    @ApiOperation(value = "Deletes a skill", nickname = "deleteSkill", notes = "", tags={ "skills", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Skill not found") })
    @RequestMapping(value = "/skills/{skillId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSkill(@ApiParam(value = "Skill ID to delete",required=true) @PathVariable("skillId") Long skillId);


    @ApiOperation(value = "Find skill by ID", nickname = "getSkillById", notes = "Returns a single skill", response = Contact.class, tags={ "skills", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Contact.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Contact not found") })
    @RequestMapping(value = "/skills/{skillId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Skill> getSkillById(@ApiParam(value = "ID of skill to return",required=true) @PathVariable("skillId") Long skillId);


    @ApiOperation(value = "List all skills", nickname = "listSkills", notes = "", response = Skill.class, responseContainer = "List", tags={ "skills", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Skill.class, responseContainer = "List") })
    @RequestMapping(value = "/skills",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Skill>> listSkills();


    @ApiOperation(value = "Update an existing skill", nickname = "updateSkill", notes = "", tags={ "skills", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Skill not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/skills",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateSkill(@ApiParam(value = "Skill that needs to be updated" ,required=true )  @Valid @RequestBody Skill body);

}
