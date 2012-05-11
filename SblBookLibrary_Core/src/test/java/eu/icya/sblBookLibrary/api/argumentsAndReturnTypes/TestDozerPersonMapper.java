package eu.icya.sblBookLibrary.api.argumentsAndReturnTypes;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import eu.icya.sblBookLibrary.api.argumentsAndReturnTypes.UnPerson;
import eu.icya.sblBookLibrary.model.people.Person;

public class TestDozerPersonMapper {
	@Test
	public void testPersonMapper() {
		UnPerson unPerson = new UnPerson();
		final String EMAIL = "anEmail@address.com";
		final String FIRST_NAME = "Andy";
		final String SURNAME = "Boyle";
		unPerson.setEmailAddress(EMAIL);
		unPerson.setFirstName(FIRST_NAME);
		unPerson.setSurname(SURNAME);
		Mapper mapper = new DozerBeanMapper();
		Person mappedPerson =  mapper.map(unPerson, Person.class);
		assertEquals("Email must match", mappedPerson.getEmailAddress(), EMAIL);
		assertEquals("Fist Name must match", mappedPerson.getFirstName(), FIRST_NAME);
		assertEquals("Surname must match", mappedPerson.getSurname(), SURNAME);
	}
}
