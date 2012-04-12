package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class TestInitialisedState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToPreInitialise();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToInitialised();
  }

  @Test
  public void testCanMoveToProposedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToProposed();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToConfirmedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToConfirmed();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToDeclinedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToDeclined();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToActiveState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToActive();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToOverdue();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToReturnedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToReturned();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToCancelledState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new InitialisedState(borrowLoan);
    state.setToCancelled();
  }



}
