package eu.icya.sblBookLibrary.api.argumentsAndReturnTypes;

import java.util.Collections;
import java.util.Set;

public class UnAuthor {
	private Set<UnBook> booksAuthored = Collections.emptySet();

	public Set<UnBook> getBooksAuthored() {
		return booksAuthored;
	}

	public void setBooksAuthored(Set<UnBook> booksAuthored) {
		this.booksAuthored = booksAuthored;
	}
}
