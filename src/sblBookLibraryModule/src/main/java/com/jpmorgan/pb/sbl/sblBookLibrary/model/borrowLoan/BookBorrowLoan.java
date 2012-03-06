package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import org.joda.time.LocalDate;

import com.jpmorgan.pb.sbl.sblBookLibrary.common.Versioned;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.book.Book;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Person;

public class BookBorrowLoan implements BorrowLoanState, Versioned {

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

  // INentionally package level setter
  void setState(BorrowLoanState state) throws IllegalStateChangeException {
      this.state = state;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    state.setToPreInitialise();
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    state.setToInitialised();
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    state.setToProposed();
  }

  @Override
  public void setToConfirmed() throws IllegalStateChangeException {
    state.setToConfirmed();
  }

  @Override
  public void setToDeclined() throws IllegalStateChangeException {
    state.setToDeclined();
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
  public void setToReturned() throws IllegalStateChangeException {
    state.setToReturned();
  }

  @Override
  public void setToCancelled() throws IllegalStateChangeException {
    state.setToCancelled();
  }

}
