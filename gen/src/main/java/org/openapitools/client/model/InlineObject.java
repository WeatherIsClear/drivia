/*
 * Member API Spec
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.LocalDate;

/**
 * InlineObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-01T01:00:37.104579+09:00[Asia/Seoul]")
public class InlineObject {
  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_PASSWORD = "password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_NICKNAME = "nickname";
  @SerializedName(SERIALIZED_NAME_NICKNAME)
  private String nickname;

  public static final String SERIALIZED_NAME_BIRTH = "birth";
  @SerializedName(SERIALIZED_NAME_BIRTH)
  private LocalDate birth;

  public static final String SERIALIZED_NAME_GENDER = "gender";
  @SerializedName(SERIALIZED_NAME_GENDER)
  private Integer gender;

  public static final String SERIALIZED_NAME_PHONE = "phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private String phone;


  public InlineObject username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "?????????", value = "")

  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public InlineObject password(String password) {
    
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ehddud123!", value = "")

  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public InlineObject email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "yeongdonge@gmail.com", value = "")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public InlineObject nickname(String nickname) {
    
    this.nickname = nickname;
    return this;
  }

   /**
   * Get nickname
   * @return nickname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "???5?????????", value = "")

  public String getNickname() {
    return nickname;
  }


  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public InlineObject birth(LocalDate birth) {
    
    this.birth = birth;
    return this;
  }

   /**
   * Get birth
   * @return birth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Mon Feb 09 09:00:00 KST 1998", value = "")

  public LocalDate getBirth() {
    return birth;
  }


  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }


  public InlineObject gender(Integer gender) {
    
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getGender() {
    return gender;
  }


  public void setGender(Integer gender) {
    this.gender = gender;
  }


  public InlineObject phone(String phone) {
    
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "010-1234-5678", value = "")

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    this.phone = phone;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject inlineObject = (InlineObject) o;
    return Objects.equals(this.username, inlineObject.username) &&
        Objects.equals(this.password, inlineObject.password) &&
        Objects.equals(this.email, inlineObject.email) &&
        Objects.equals(this.nickname, inlineObject.nickname) &&
        Objects.equals(this.birth, inlineObject.birth) &&
        Objects.equals(this.gender, inlineObject.gender) &&
        Objects.equals(this.phone, inlineObject.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, email, nickname, birth, gender, phone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    birth: ").append(toIndentedString(birth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

