package eu.icya.sblBookLibrary.model.borrowLoan;

public interface BorrowLoanState {
  
  public void setToPreInitialise() throws IllegalStateChangeException;

  public void setToInitialised() throws IllegalStateChangeException;

  public void setToProposed() throws IllegalStateChangeException;

  public void setToConfirmedInPrinciple() throws IllegalStateChangeException;

  public void setToLoanerDeclined() throws IllegalStateChangeException;

  public void setToActive() throws IllegalStateChangeException;

  public void setToOverdue() throws IllegalStateChangeException;

  public void setToBookReturned() throws IllegalStateChangeException;

  public void setToBorrowerCancelled() throws IllegalStateChangeException;
}
