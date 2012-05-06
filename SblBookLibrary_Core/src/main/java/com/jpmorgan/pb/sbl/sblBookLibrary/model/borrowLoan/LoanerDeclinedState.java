package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

public class LoanerDeclinedState extends AbstractBorrowLoanState {

  @SuppressWarnings("unused")
  private BookBorrowLoan bookBorrowLoan;

  public LoanerDeclinedState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to Initialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to ConfirmedInPrincipleState!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to LoanerDeclinedState!");
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to Active!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to Book Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Loaner Declined Cancelled State to Borrower Cancelled!");
  }

}
