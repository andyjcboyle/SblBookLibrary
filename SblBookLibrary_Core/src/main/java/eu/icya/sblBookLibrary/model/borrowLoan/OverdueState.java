package eu.icya.sblBookLibrary.model.borrowLoan;

public class OverdueState extends AbstractBorrowLoanState {

  private BookBorrowLoan bookBorrowLoan;
  
  public OverdueState(BookBorrowLoan bookBorrowLoan) {
    this.bookBorrowLoan = bookBorrowLoan;
  }

  @Override
  public void setToPreInitialise() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to PreInitialised!");
  }

  @Override
  public void setToInitialised() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to PreInitialised!");
  }

  @Override
  public void setToProposed() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to Proposed!");
  }

  @Override
  public void setToConfirmedInPrinciple() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to Confirmed!");
  }

  @Override
  public void setToLoanerDeclined() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to Proposed!");
  }

  @Override
  public void setToActive() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new ActiveState(bookBorrowLoan));
  }

  @Override
  public void setToOverdue() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to Proposed!");
  }

  @Override
  public void setToBookReturned() throws IllegalStateChangeException {
    bookBorrowLoan.setState(new BookReturnedState(bookBorrowLoan));
  }

  @Override
  public void setToBorrowerCancelled() throws IllegalStateChangeException {
    logWarningAndThrowException("Cannot move from Overdue In Principle State to Proposed!");
  }

}
