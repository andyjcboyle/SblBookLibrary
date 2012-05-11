package eu.icya.sblBookLibrary.model.borrowLoan;

public class BorrowerCancelledState extends AbstractBorrowLoanState {

  @SuppressWarnings("unused")
  private BookBorrowLoan bookBorrowLoan;

  public BorrowerCancelledState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to Initialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to ConfirmedInPrincipleState!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to LoanerDeclinedState!");
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to Active!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to Book Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Borrower Cancelled State to Borrower Cancelled!");
  }

}
