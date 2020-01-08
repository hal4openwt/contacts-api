package fr.hildenbrand.contactapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import fr.hildenbrand.contactapi.model.Contact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Skill
 */
@Entity
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-08T11:47:40.137+01:00")

public class Skill   {
  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets level
   */
  public enum LevelEnum {
    VERY_GOOD("very good"),
    
    GOOD("good"),
    
    AVERAGE("average"),
    
    POOR("poor");

    private String value;

    LevelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LevelEnum fromValue(String text) {
      for (LevelEnum b : LevelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("level")
  private LevelEnum level = null;

  @JsonProperty("contacts")
  @Valid
  @ManyToMany(mappedBy = "skills")
  private List<Contact> contacts = null;

  public Skill id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Skill name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "C++", required = true, value = "")
  @NotNull
  @NotBlank

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Skill level(LevelEnum level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
  **/
  @ApiModelProperty(example = "very good", required = true, value = "")
  @NotNull


  public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }

  public Skill contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public Skill addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
   * Get contacts
   * @return contacts
  **/
  @Transient
  private static final List<Skill> emptySkillList = new ArrayList<>();
  
  @ApiModelProperty(example = "[]", value = "")

  @Valid

  public List<Contact> getContacts() {
	  if (contacts!=null) {
		  for (Contact contact: contacts)
			  contact.setSkills(emptySkillList);
	  }
	  return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Skill skill = (Skill) o;
    return Objects.equals(this.id, skill.id) &&
        Objects.equals(this.name, skill.name) &&
        Objects.equals(this.level, skill.level) &&
        Objects.equals(this.contacts, skill.contacts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, level, contacts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Skill {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

