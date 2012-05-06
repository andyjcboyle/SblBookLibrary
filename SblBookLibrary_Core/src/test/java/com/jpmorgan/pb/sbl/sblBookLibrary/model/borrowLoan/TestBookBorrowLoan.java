package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.pb.sbl.sblBookLibrary.model.book.Book;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Author;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Person;

public class TestBookBorrowLoan {

  public static final String BOOK_TITLE = "Working Effectively With Legacy Code";
  public static final String AUTHOR_FIRST_NAME = "Michael";
  public static final String AUTHOR_SURNAME = "Feathers";
  public static final String BORROWER_FIRST_NAME = "Andy";
  public static final String BORROWER_SURNAME = "Boyle";
  public static final String LENDER_FIRST_NAME = "Mighty";
  public static final String LENDER_SURNAME = "Mouse";

  private Book theBook;
  private Person theBorrower;
  private Person theLender;
  private LocalDate theBorrowLoanStartDate;
  private LocalDate theAgreementDate;
  private LocalDate theBorrowLoanEndDate;

  @Before
  public void setup() {
    setupBook();
    setupBorrower();
    setupLender();
    theBorrowLoanStartDate = new LocalDate(2012, 5, 2);
    theAgreementDate = new LocalDate(2012,5,3);
    theBorrowLoanEndDate = new LocalDate(2012,5,21);
  }

  public void setupBorrower() {
    theBorrower = new Person();
    theBorrower.setFirstName(BORROWER_FIRST_NAME);
    theBorrower.setSurname(BORROWER_SURNAME);
  }

  public void setupLender() {
    theLender = new Person();
    theLender.setFirstName(LENDER_FIRST_NAME);
    theLender.setSurname(LENDER_SURNAME);
  }

  public void setupBook() {
    theBook = new Book();

    Author anAuthor = new Author();
    anAuthor.setFirstName(AUTHOR_FIRST_NAME);
    anAuthor.setSurname(AUTHOR_SURNAME);
    Set<Book> booksAuthored = new HashSet<Book>();
    booksAuthored.add(theBook);
    Set<Author> authors = new HashSet<Author>();
    authors.add(anAuthor);
    anAuthor.setBooksAuthored(booksAuthored);

    theBook.setAuthors(authors);
    theBook.setTitle(BOOK_TITLE);
  }

  @Test
  public void testCreateBasicBorrowLoan() {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    assertTrue("The BorrowLoan should not be null", borrowLoan != null);
  }

  @Test
  public void testDefaultSetupOfBookBorrowLoan() {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    assertEquals("Lender should be null", borrowLoan.getLender(), null);
    assertEquals("Borrower should be null", borrowLoan.getBorrower(), null);
    assertEquals("Book should be null", borrowLoan.getBook(), null);
    assertEquals("Trade agreed date should be null", borrowLoan.getTradeAgreedDate(), null);
    assertEquals("Borrow Loan start date should be null", borrowLoan.getBorrowLoanStartDate(), null);
    assertEquals("Borrow Loan end date should be null", borrowLoan.getBorrowLoanEndDate(), null);
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_PreInitialised_To_Initialised_Fail_Since_NoBorrower() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_PreInitialised_To_Initialised_Fail_Since_NoBook() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_PreInitialised_To_Initialised_Fail_Since_NoStartDate() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setToInitialised();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_PreInitialised_To_Initialised_Fail_Since_NoDetails() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setToInitialised();
  }

  @Test
  public void testStateChange_PreInitialised_To_Initialised() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
  }

  @Test
  public void testStateChange_PreInitialised_To_BorrowerCancelled() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToBorrowerCancelled();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_Through_To_Proposed_Fail_No_Lender() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setToProposed();
  }

  @Test
  public void testStateChange_Through_To_Proposed() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
  }

  @Test
  public void testStateChange_Through_To_Proposed_Then_Cancelled() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setToBorrowerCancelled();
  }

  @Test
  public void testStateChange_Through_To_Proposed_Then_LoanerDeclined() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setToLoanerDeclined();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_Through_To_ConfirmedInPrinciple_Fail_NoAgreedDate() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setToConfirmedInPrinciple();
  }

  @Test
  public void testStateChange_Through_To_ConfirmedInPrinciple() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
  }

  @Test
  public void testStateChange_Through_To_ConfirmedInPrinciple_Then_Cancelled() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToBorrowerCancelled();
  }

  @Test
  public void testStateChange_Through_To_ConfirmedInPrinciple_Then_LoanerDeclined() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToLoanerDeclined();
  }

  @Test
  public void testStateChange_Through_To_Active() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToActive();
  }

  @Test
  public void testStateChange_Through_To_Active_Then_Overdue() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToActive();
    borrowLoan.setToOverdue();
  }

  @Test
  public void testStateChange_Through_To_Active_Then_Overdue_And_Active_Again() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToActive();
    borrowLoan.setToOverdue();
    borrowLoan.setToActive();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testStateChange_Through_To_Active_Then_Overdue_And_Active_BookReturned_Fail_NoReturnDate()
      throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToActive();
    borrowLoan.setToOverdue();
    borrowLoan.setToBookReturned();
  }

  
  @Test
  public void testStateChange_Through_To_Active_Then_Overdue_And_Active_BookReturned()
      throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToActive();
    borrowLoan.setToOverdue();
    borrowLoan.setBorrowLoanEndDate(theBorrowLoanEndDate);
    borrowLoan.setToBookReturned();
  }

  @Test
  public void testStateChange_Through_To_Active_Then_BookReturned() throws IllegalStateChangeException {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    borrowLoan.setBorrower(theBorrower);
    borrowLoan.setBook(theBook);
    borrowLoan.setBorrowLoanStartDate(theBorrowLoanStartDate);
    borrowLoan.setToInitialised();
    borrowLoan.setLender(theLender);
    borrowLoan.setToProposed();
    borrowLoan.setTradeAgreedDate(theAgreementDate);
    borrowLoan.setToConfirmedInPrinciple();
    borrowLoan.setToActive();
    borrowLoan.setBorrowLoanEndDate(theBorrowLoanEndDate);
    borrowLoan.setToBookReturned();
  }

}
