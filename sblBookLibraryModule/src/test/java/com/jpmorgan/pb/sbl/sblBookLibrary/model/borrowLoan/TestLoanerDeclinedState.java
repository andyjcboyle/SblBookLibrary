package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class TestLoanerDeclinedState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToPreInitialise();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToInitialised();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCanMoveToProposedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToProposed();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToConfirmedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToConfirmedInPrinciple();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToDeclinedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToLoanerDeclined();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToActiveState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToActive();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToOverdue();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToReturnedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToBookReturned();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToCancelledState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new LoanerDeclinedState(borrowLoan);
    state.setToBorrowerCancelled();
  }

}
