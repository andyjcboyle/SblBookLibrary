package eu.icya.sblBookLibrary.model.people;

import java.util.Collections;
import java.util.Set;

import eu.icya.sblBookLibrary.model.book.Book;

public class Author extends Person {
  private Set<Book> booksAuthored = Collections.emptySet();

  public Set<Book> getBooksAuthored() {
    return booksAuthored;
  }

  public void setBooksAuthored(Set<Book> booksAuthored) {
    this.booksAuthored = booksAuthored;
  }
}
