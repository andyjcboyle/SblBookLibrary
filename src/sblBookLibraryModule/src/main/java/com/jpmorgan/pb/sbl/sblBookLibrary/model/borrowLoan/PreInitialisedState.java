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
  public void setToConfirmed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Confirmed!");
  }

  @Override
  public void setToDeclined() throws IllegalStateChangeException {
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
  public void setToReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Pre-Initialised state to Returned!");
  }

  @Override
  public void setToCancelled() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new CancelledState());
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
