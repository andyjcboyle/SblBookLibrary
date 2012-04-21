package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

public class ConfirmedInPrincipleState extends AbstractBorrowLoanState {

  private BookBorrowLoan bookBorrowLoan;
  
  public ConfirmedInPrincipleState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Confirmed In Principle State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Confirmed In Principle State to PreInitialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Confirmed In Principle State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Confirmed In Principle State to Confirmed!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new LoanerDeclinedState(bookBorrowLoan));
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new ActiveState(bookBorrowLoan));
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Confirmed In Principle State to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Confirmed In Principle State to Book Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new BorrowerCancelledState(bookBorrowLoan));
  }

}
