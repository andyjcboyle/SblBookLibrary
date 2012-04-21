package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

public class ProposedState extends AbstractBorrowLoanState {

  private BookBorrowLoan bookBorrowLoan;
  
  public ProposedState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Proposed State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Proposed State to PreInitialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Proposed State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new ConfirmedInPrincipleState(bookBorrowLoan));
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new LoanerDeclinedState(bookBorrowLoan));
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Proposed State to Active!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Proposed State to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Proposed State to Book Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new BorrowerCancelledState(bookBorrowLoan));
  }

}
