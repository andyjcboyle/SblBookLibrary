package eu.icya.sblBookLibrary.model.book;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


import eu.icya.sblBookLibrary.model.book.Book;
import eu.icya.sblBookLibrary.model.people.Author;

public class TestBook {

  public static final String AUTHOR1_FIRSTNAME = "Jeff";
  public static final String AUTHOR1_SURNAME = "Linwood";
  public static final String AUTHOR2_FIRSTNAME = "Dave";
  public static final String AUTHOR2_SURNAME = "Minter";
  public static final String BOOK_TITLE = "Beginning Hibernate";
  public static final String BOOK_SUBTITLE = "An introduction to persistence using hibernate 3.5";
  public static final String BOOK_EDITION = "2nd Edition";

  @Test
  public void testCreateNewDefaultBook() {
    Book myBook = new Book();
    Set<Author> authorsOfTheBook = myBook.getAuthors();
    assertTrue("Default book should have empty set of authors", authorsOfTheBook.size() == 0);
  }

  @Test
  public void testCreateNewBook() {
    Author author1 = createAuthor(AUTHOR1_FIRSTNAME, AUTHOR1_SURNAME);
    Author author2 = createAuthor(AUTHOR2_FIRSTNAME, AUTHOR2_SURNAME);

    HashSet<Author> authors = new HashSet<Author>();
    authors.add(author1);
    authors.add(author2);

    Book hibernateBook = new Book();
    hibernateBook.setTitle(BOOK_TITLE);
    hibernateBook.setSubtitle(BOOK_SUBTITLE);
    hibernateBook.setEdition(BOOK_EDITION);
    hibernateBook.setAuthors(authors);
    assertEquals("Unexpected book title", BOOK_TITLE, hibernateBook.getTitle());
    assertEquals("Unexpected book subtitle", BOOK_SUBTITLE, hibernateBook.getSubtitle());
    assertEquals("Unexpected edition", BOOK_EDITION, hibernateBook.getEdition());
    assertTrue("Authors should contain expected ones", hibernateBook.getAuthors().contains(author1));
    assertTrue("Authors should contain expected ones", hibernateBook.getAuthors().contains(author2));
  }

  public static final Author createAuthor(final String firstName, final String surname) {
    Author author = new Author();
    author.setFirstName(firstName);
    author.setSurname(surname);
    return author;
  }

}
