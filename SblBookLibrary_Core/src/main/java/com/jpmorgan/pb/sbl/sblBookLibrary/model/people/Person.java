package com.jpmorgan.pb.sbl.sblBookLibrary.model.people;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.validator.routines.EmailValidator;

import com.jpmorgan.pb.sbl.sblBookLibrary.common.Versioned;

@Entity
@Table(name="PERSON")
public class Person implements Versioned {

  @Id
  private long id;
  private String firstName;
  private String surname;
  private String emailAddress;

  private static final EmailValidator emailValidator = EmailValidator.getInstance();

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    if (!emailValidator.isValid(emailAddress)) {
      throw new IllegalArgumentException("Invalid Email Address ... " + emailAddress);
    }
    this.emailAddress = emailAddress;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

}
