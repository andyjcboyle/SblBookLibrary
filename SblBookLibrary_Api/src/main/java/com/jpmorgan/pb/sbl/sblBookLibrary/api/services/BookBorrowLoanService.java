package com.jpmorgan.pb.sbl.sblBookLibrary.api.services;

import javax.ejb.Remote;

import org.joda.time.LocalDate;

import com.jpmorgan.pb.sbl.sblBookLibrary.api.argumentsAndReturnTypes.UnBook;
import com.jpmorgan.pb.sbl.sblBookLibrary.api.argumentsAndReturnTypes.UnPerson;

@Remote
public interface BookBorrowLoanService {
	public void createAnInitialisedBookBorrowLoan(UnPerson thePerson,
			UnBook theBook, LocalDate proposedStartDate);
}
