/*
 * IriusRisk API
 * Products API
 *
 * OpenAPI spec version: 1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.LibraryUseCase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RiskPattern
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-26T11:09:51.654Z")
public class RiskPattern {
  @SerializedName("ref")
  private String ref = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("desc")
  private String desc = null;

  @SerializedName("weaknesses")
  private List<LibraryUseCase> weaknesses = null;

  @SerializedName("countermeasures")
  private List<LibraryUseCase> countermeasures = null;

  @SerializedName("usecases")
  private List<LibraryUseCase> usecases = null;

  public RiskPattern ref(String ref) {
    this.ref = ref;
    return this;
  }

   /**
   * Get ref
   * @return ref
  **/
  @ApiModelProperty(value = "")
  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public RiskPattern name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RiskPattern desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public RiskPattern weaknesses(List<LibraryUseCase> weaknesses) {
    this.weaknesses = weaknesses;
    return this;
  }

  public RiskPattern addWeaknessesItem(LibraryUseCase weaknessesItem) {
    if (this.weaknesses == null) {
      this.weaknesses = new ArrayList<LibraryUseCase>();
    }
    this.weaknesses.add(weaknessesItem);
    return this;
  }

   /**
   * Get weaknesses
   * @return weaknesses
  **/
  @ApiModelProperty(value = "")
  public List<LibraryUseCase> getWeaknesses() {
    return weaknesses;
  }

  public void setWeaknesses(List<LibraryUseCase> weaknesses) {
    this.weaknesses = weaknesses;
  }

  public RiskPattern countermeasures(List<LibraryUseCase> countermeasures) {
    this.countermeasures = countermeasures;
    return this;
  }

  public RiskPattern addCountermeasuresItem(LibraryUseCase countermeasuresItem) {
    if (this.countermeasures == null) {
      this.countermeasures = new ArrayList<LibraryUseCase>();
    }
    this.countermeasures.add(countermeasuresItem);
    return this;
  }

   /**
   * Get countermeasures
   * @return countermeasures
  **/
  @ApiModelProperty(value = "")
  public List<LibraryUseCase> getCountermeasures() {
    return countermeasures;
  }

  public void setCountermeasures(List<LibraryUseCase> countermeasures) {
    this.countermeasures = countermeasures;
  }

  public RiskPattern usecases(List<LibraryUseCase> usecases) {
    this.usecases = usecases;
    return this;
  }

  public RiskPattern addUsecasesItem(LibraryUseCase usecasesItem) {
    if (this.usecases == null) {
      this.usecases = new ArrayList<LibraryUseCase>();
    }
    this.usecases.add(usecasesItem);
    return this;
  }

   /**
   * Get usecases
   * @return usecases
  **/
  @ApiModelProperty(value = "")
  public List<LibraryUseCase> getUsecases() {
    return usecases;
  }

  public void setUsecases(List<LibraryUseCase> usecases) {
    this.usecases = usecases;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RiskPattern riskPattern = (RiskPattern) o;
    return Objects.equals(this.ref, riskPattern.ref) &&
        Objects.equals(this.name, riskPattern.name) &&
        Objects.equals(this.desc, riskPattern.desc) &&
        Objects.equals(this.weaknesses, riskPattern.weaknesses) &&
        Objects.equals(this.countermeasures, riskPattern.countermeasures) &&
        Objects.equals(this.usecases, riskPattern.usecases);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ref, name, desc, weaknesses, countermeasures, usecases);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RiskPattern {\n");
    
    sb.append("    ref: ").append(toIndentedString(ref)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    weaknesses: ").append(toIndentedString(weaknesses)).append("\n");
    sb.append("    countermeasures: ").append(toIndentedString(countermeasures)).append("\n");
    sb.append("    usecases: ").append(toIndentedString(usecases)).append("\n");
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
