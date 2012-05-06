package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

class InitialisedState extends AbstractBorrowLoanState {

  private BookBorrowLoan bookBorrowLoan;

  public InitialisedState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Initialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new ProposedState(bookBorrowLoan));
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Confirmed!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Declined!");
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Active!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new BorrowerCancelledState(bookBorrowLoan));
  }

}
