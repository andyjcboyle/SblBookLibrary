package eu.icya.sblBookLibrary.api.services;

import java.util.Set;

import javax.ejb.Remote;

import eu.icya.sblBookLibrary.api.argumentsAndReturnTypes.UnPerson;

@Remote
public interface PersonService {
	public void addNewPerson(UnPerson personToAdd);
	public void removePerson(UnPerson personToRemove);
	public void editPerson(UnPerson personToEdit);
	public Set<UnPerson> getAllPersons();
	public Set<UnPerson> findPersonsWithFirstName(String firstName);
	public Set<UnPerson> findPersonsWithSurnameName(String surname);
}
