package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

public class IllegalStateChangeException extends Exception {
  private static final long serialVersionUID = 1L;

  public IllegalStateChangeException (String msg) {
    super(msg);
  }
}
