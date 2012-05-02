package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpmorgan.pb.sbl.sblBookLibrary.common.Versioned;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.book.Book;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Person;

public class BookBorrowLoan implements BorrowLoanState, Versioned {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private long id;
  private Person borrower;
  private Person lender;
  private Book book;
  private LocalDate tradeAgreedDate;
  private LocalDate borrowLoanStartDate;
  private LocalDate borrowLoanEndDate;
  private BorrowLoanState state = new PreInitialisedState(this);

  public Person getBorrower() {
    return borrower;
  }

  public void setBorrower(Person borrower) {
    this.borrower = borrower;
  }

  public Person getLender() {
    return lender;
  }

  public void setLender(Person lender) {
    this.lender = lender;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public LocalDate getTradeAgreedDate() {
    return tradeAgreedDate;
  }

  public void setTradeAgreedDate(LocalDate tradeAgreedDate) {
    this.tradeAgreedDate = tradeAgreedDate;
  }

  public LocalDate getBorrowLoanStartDate() {
    return borrowLoanStartDate;
  }

  public void setBorrowLoanStartDate(LocalDate borrowLoanStartDate) {
    this.borrowLoanStartDate = borrowLoanStartDate;
  }

  public LocalDate getBorrowLoanEndDate() {
    return borrowLoanEndDate;
  }

  public void setBorrowLoanEndDate(LocalDate borrowLoanEndDate) {
    this.borrowLoanEndDate = borrowLoanEndDate;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  public String getStateIndicator() {
    return state.getClass().getSimpleName();
  }

  // Intentionally package level setter
  void setState(BorrowLoanState state) throws IllegalStateChangeException {
    this.state = state;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    state.setToPreInitialise();
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    if (borrower == null || book == null || borrowLoanStartDate == null) {
      final String ERROR_MSG = "Minimum criteria not set to change state to Initialised. Need to set 'borrower', "
          + "'book' and the 'borrow loan start date'.";
      log.warn(ERROR_MSG);
      throw new IllegalStateChangeException(ERROR_MSG);
    }
    state.setToInitialised();
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    if (lender == null) {
      final String ERROR_MSG = "Minimum criteria not set to change state to Proposed. Need to set 'lender'";
      log.warn(ERROR_MSG);
      throw new IllegalStateChangeException(ERROR_MSG);
    }
    state.setToProposed();
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    if ( tradeAgreedDate == null) {
      final String ERROR_MSG = "Minimum criteria not set to change state to ConfirmedInPrinciple. Need to set 'tradeAgreedDate'";
      log.warn(ERROR_MSG);
      throw new IllegalStateChangeException(ERROR_MSG);
    }
    state.setToConfirmedInPrinciple();
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    state.setToLoanerDeclined();
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    state.setToActive();
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    state.setToOverdue();
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    if ( borrowLoanEndDate == null) {
      final String ERROR_MSG = "Minimum criteria not set to change state to BookReturned. Need to set 'borrowLoanEndDate'";
      log.warn(ERROR_MSG);
      throw new IllegalStateChangeException(ERROR_MSG);
    }
    state.setToBookReturned();
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    state.setToBorrowerCancelled();
  }

}
