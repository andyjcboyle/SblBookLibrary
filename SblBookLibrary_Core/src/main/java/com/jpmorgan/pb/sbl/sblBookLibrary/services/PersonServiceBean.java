package com.jpmorgan.pb.sbl.sblBookLibrary.services;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.jpmorgan.pb.sbl.sblBookLibrary.api.argumentsAndReturnTypes.UnPerson;
import com.jpmorgan.pb.sbl.sblBookLibrary.api.services.PersonService;
import com.jpmorgan.pb.sbl.sblBookLibrary.api.utils.JndiBindingConstants;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Person;

@Stateless
@RemoteBinding(jndiBinding = JndiBindingConstants.REMOTE_PERSON_SERVICE)
public class PersonServiceBean implements PersonService {

	private Session session;
    private Mapper mapper;
    
	@PostConstruct
	public void init() {
	    SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	    session = factory.openSession();
	    mapper = new DozerBeanMapper();
	}

	// TODO AOP all the transaction stuff on beans, all bean!
	// TODO Add a caching level in front of hibernate
	@Override
	public void addNewPerson(UnPerson personToAdd) {
		Person newPersonToAdd =  mapper.map(personToAdd, Person.class);
		
		Transaction tx = session.beginTransaction();
	    tx.begin();
	    session.save(newPersonToAdd);
	    tx.commit();
	}

	@Override
	public void removePerson(UnPerson personToRemove) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPerson(UnPerson personToEdit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<UnPerson> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UnPerson> findPersonsWithFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UnPerson> findPersonsWithSurnameName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

}
