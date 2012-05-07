package com.jpmorgan.pb.sbl.sblBookLibrary.beans.borrowLoan;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.jpmorgan.pb.sbl.sblBookLibrary.api.services.TestBean;
import com.jpmorgan.pb.sbl.sblBookLibrary.api.utils.JndiBindingConstants;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Person;

@Stateless
@RemoteBinding(jndiBinding = JndiBindingConstants.REMOTE_ANDYTEST)
public class MyTestBean implements TestBean {

  public String returnSomeMessage() {
    SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    tx.begin();
    Person aPerson = new Person();
    aPerson.setFirstName("Andy");
    aPerson.setSurname("Boyle");
    aPerson.setEmailAddress("andy@some.com");
    session.save(aPerson);
    tx.commit();
    
    return "Hello there, toodly doo! And we have just saved ... " + aPerson.getFirstName();
  }

}
