package com.jpmorgan.pb.sbl.sblBookLibrary.model.people;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.jpmorgan.pb.sbl.sblBookLibrary.model.book.Book;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.book.TestBook;

public class TestAuthor {
  
  @Test
  public void testBasicAuthorNoBooks() {
    Author anAuthor = new Author();
    assertTrue("Non null set expected", anAuthor.getBooksAuthored() != null);
    assertEquals("Empty set expected", 0, anAuthor.getBooksAuthored().size());
  }
  
  @Test
  public void testBasicAuthorOneBook() {
    Author anAuthor = new Author();
    anAuthor.setFirstName(TestPerson.FIRSTNAME);
    anAuthor.setSurname(TestPerson.SURNAME);
    anAuthor.setBooksAuthored(createSomeBooks());
    assertEquals("Authored only 1 book", 1, anAuthor.getBooksAuthored().size());
  }

  private Set<Book> createSomeBooks() {
    Set<Book> books = new HashSet<Book>();
    Book aBook = new Book();
    aBook.setTitle(TestBook.BOOK_TITLE);
    aBook.setSubtitle(TestBook.BOOK_SUBTITLE);
    aBook.setEdition(TestBook.BOOK_TITLE);
    books.add(aBook);
    return books;
  }
}

