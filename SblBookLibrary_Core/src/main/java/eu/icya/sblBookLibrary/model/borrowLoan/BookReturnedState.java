package eu.icya.sblBookLibrary.model.borrowLoan;

public class BookReturnedState extends AbstractBorrowLoanState {

  @SuppressWarnings("unused")
  private BookBorrowLoan bookBorrowLoan;

  public BookReturnedState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to Initialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to ConfirmedInPrincipleState!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to LoanerDeclinedState!");
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to Active!");
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to Overdue!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to Book Returned!");
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Book Returned Cancelled State to Borrower Cancelled!");
  }

}
