package eu.icya.sblBookLibrary.api.services;

import javax.ejb.Remote;

import org.joda.time.LocalDate;

import eu.icya.sblBookLibrary.api.argumentsAndReturnTypes.UnBook;
import eu.icya.sblBookLibrary.api.argumentsAndReturnTypes.UnPerson;

@Remote
public interface BookBorrowLoanService {
	public void createBookBorrowLoan(UnPerson thePerson, UnBook theBook,
			LocalDate proposedStartDate);

	// TODO : This interface needs to be finished. Should refer to bookLoans by
	// id etc
	public void setBorrowLoanToProposed();

}
