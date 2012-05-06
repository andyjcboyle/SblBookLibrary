package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

public class ActiveState extends AbstractBorrowLoanState {

  private BookBorrowLoan bookBorrowLoan;
  
  public ActiveState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to PreInitialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to Confirmed!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to Proposed!");
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to Proposed!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new OverdueState(bookBorrowLoan));
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new BookReturnedState(bookBorrowLoan));
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Active In Principle State to Proposed!");
  }

}
