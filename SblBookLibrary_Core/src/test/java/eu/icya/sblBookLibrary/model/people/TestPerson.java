package eu.icya.sblBookLibrary.model.people;

import org.junit.Test;

import eu.icya.sblBookLibrary.model.people.Person;
import static org.junit.Assert.assertEquals;

public class TestPerson {
  
  public static final String FIRSTNAME = "Andy";
  public static final String SURNAME = "Boyle";
  public static final String EMAIL = "andyboyle@somedomain.com";
  
  @Test
  public void testNewBasicPerson() {
    Person aPerson = new Person();
    aPerson.setFirstName(FIRSTNAME);
    aPerson.setSurname(SURNAME);
    aPerson.setEmailAddress(EMAIL);
    assertEquals("Firstname is not as expected", FIRSTNAME, aPerson.getFirstName());
    assertEquals("Surname is not as expected", SURNAME, aPerson.getSurname());
    assertEquals("Email is not as expected", EMAIL, aPerson.getEmailAddress());
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testIllegalEmailAddress() {
    Person aPerson = new Person();
    aPerson.setEmailAddress("InvalidEmail");
  }
  
}
