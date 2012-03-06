package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

public interface BorrowLoanState {
  
  public void setToPreInitialise() throws IllegalStateChangeException;

  public void setToInitialised() throws IllegalStateChangeException;

  public void setToProposed() throws IllegalStateChangeException;

  public void setToConfirmed() throws IllegalStateChangeException;

  public void setToDeclined() throws IllegalStateChangeException;

  public void setToActive() throws IllegalStateChangeException;

  public void setToOverdue() throws IllegalStateChangeException;

  public void setToReturned() throws IllegalStateChangeException;

  public void setToCancelled() throws IllegalStateChangeException;
}
