package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class TestPreInitialsedState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToPreInitialise();
  }
  
  @Test
  public void testCanMoveToInitialisedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToInitialised();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToProposedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToProposed();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToConfirmedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToConfirmed();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToDeclinedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToDeclined();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToActiveState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToActive();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToOverdue();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToReturnedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToReturned();
  }

  @Test
  public void testCannotMoveToCancelledState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToCancelled();
  }



}
