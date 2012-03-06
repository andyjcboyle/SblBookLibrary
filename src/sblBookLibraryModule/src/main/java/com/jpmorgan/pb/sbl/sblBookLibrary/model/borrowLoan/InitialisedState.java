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
    bookBorrowLoan.setState(new ProposedState());
  }

  @Override
  public void setToConfirmed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Initialised State to Confirmed!");
  }

  @Override
  public void setToDeclined() throws IllegalStateChangeException {
    // TODO Auto-generated method stub

  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    // TODO Auto-generated method stub

  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    // TODO Auto-generated method stub

  }

  @Override
  public void setToReturned() throws IllegalStateChangeException {
    // TODO Auto-generated method stub

  }

  @Override
  public void setToCancelled() throws IllegalStateChangeException {
    // TODO Auto-generated method stub

  }

}
