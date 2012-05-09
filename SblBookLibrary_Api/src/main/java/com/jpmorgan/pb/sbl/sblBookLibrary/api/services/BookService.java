package com.jpmorgan.pb.sbl.sblBookLibrary.api.services;

import java.util.Set;

import javax.ejb.Remote;

import com.jpmorgan.pb.sbl.sblBookLibrary.api.argumentsAndReturnTypes.UnBook;

@Remote
public interface BookService {
	public void addNewBook(UnBook bookToAdd);
	public void removePerson(UnBook bookToRemove);
	public void editPerson(UnBook bookToEdit);
	public Set<UnBook> getAllBooks();
	public Set<UnBook> findBooksWithTitleLike(String titleLike);
}
