package eu.icya.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import eu.icya.sblBookLibrary.model.borrowLoan.BookBorrowLoan;
import eu.icya.sblBookLibrary.model.borrowLoan.IllegalStateChangeException;
import eu.icya.sblBookLibrary.model.borrowLoan.PreInitialisedState;

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
    state.setToConfirmedInPrinciple();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToDeclinedState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToLoanerDeclined();
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
    state.setToBookReturned();
  }

  @Test
  public void testCanMoveToCancelledState() throws IllegalStateChangeException {
    PreInitialisedState state = new PreInitialisedState(borrowLoan);
    state.setToBorrowerCancelled();
  }



}
