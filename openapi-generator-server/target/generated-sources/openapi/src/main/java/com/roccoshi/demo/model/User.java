package com.roccoshi.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-22T01:39:21.167+08:00[Asia/Shanghai]")
public class User   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("userNumber")
  private String userNumber;

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("userStatus")
  private String userStatus;

  @JsonProperty("operatorNumber")
  private String operatorNumber;

  public User id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User userNumber(String userNumber) {
    this.userNumber = userNumber;
    return this;
  }

  /**
   * Get userNumber
   * @return userNumber
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Pattern(regexp="\\d{8}") 
  public String getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String userNumber) {
    this.userNumber = userNumber;
  }

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Pattern(regexp="^[a-zA-Z]{1,40}$") 
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @ApiModelProperty(value = "")

@Pattern(regexp="(\\d{10})?") 
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User userStatus(String userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  /**
   * Get userStatus
   * @return userStatus
  */
  @ApiModelProperty(value = "")


  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  public User operatorNumber(String operatorNumber) {
    this.operatorNumber = operatorNumber;
    return this;
  }

  /**
   * Get operatorNumber
   * @return operatorNumber
  */
  @ApiModelProperty(value = "")


  public String getOperatorNumber() {
    return operatorNumber;
  }

  public void setOperatorNumber(String operatorNumber) {
    this.operatorNumber = operatorNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.userNumber, user.userNumber) &&
        Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.phone, user.phone) &&
        Objects.equals(this.userStatus, user.userStatus) &&
        Objects.equals(this.operatorNumber, user.operatorNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userNumber, userName, phone, userStatus, operatorNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userNumber: ").append(toIndentedString(userNumber)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
    sb.append("    operatorNumber: ").append(toIndentedString(operatorNumber)).append("\n");
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

