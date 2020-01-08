package fr.hildenbrand.contactapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SkillBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-08T12:44:06.373+01:00")

public class SkillBody   {
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

  public SkillBody name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "C++", required = true, value = "")
  @NotNull
  @NotBlank(message="Skill name is required")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SkillBody level(LevelEnum level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
  **/
  @ApiModelProperty(example = "very good", required = true, value = "")
  @NotNull(message="Level is required")

  public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SkillBody skillBody = (SkillBody) o;
    return Objects.equals(this.name, skillBody.name) &&
        Objects.equals(this.level, skillBody.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SkillBody {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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

