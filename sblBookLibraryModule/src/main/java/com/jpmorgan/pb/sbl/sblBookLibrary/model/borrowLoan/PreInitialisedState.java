package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;


public class PreInitialisedState extends AbstractBorrowLoanState {

  private BookBorrowLoan bookBorrowLoan;

  public PreInitialisedState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Already in Pre-initialised state!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new InitialisedState(bookBorrowLoan));
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Confirmed!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Declined!");

  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Active!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new BorrowerCancelledState(bookBorrowLoan));
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
