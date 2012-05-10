package com.jpmorgan.pb.sbl.sblBookLibrary.api.services;

import javax.ejb.Remote;

import org.joda.time.LocalDate;

import com.jpmorgan.pb.sbl.sblBookLibrary.api.argumentsAndReturnTypes.UnBook;
import com.jpmorgan.pb.sbl.sblBookLibrary.api.argumentsAndReturnTypes.UnPerson;

@Remote
public interface BookBorrowLoanService {
	public void createBookBorrowLoan(UnPerson thePerson, UnBook theBook,
			LocalDate proposedStartDate);

	// TODO : This interface needs to be finished. Should refer to bookLoans by
	// id etc
	public void setBorrowLoanToProposed();

}
