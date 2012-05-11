package eu.icya.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import eu.icya.sblBookLibrary.model.borrowLoan.AbstractBorrowLoanState;
import eu.icya.sblBookLibrary.model.borrowLoan.BookBorrowLoan;
import eu.icya.sblBookLibrary.model.borrowLoan.BorrowerCancelledState;
import eu.icya.sblBookLibrary.model.borrowLoan.IllegalStateChangeException;

public class TestBorrowerCancelledState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToPreInitialise();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToInitialised();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToProposedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToProposed();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToConfirmedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToConfirmedInPrinciple();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToDeclinedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToLoanerDeclined();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToActiveState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToActive();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToOverdue();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToReturnedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToBookReturned();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToCancelledState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new BorrowerCancelledState(borrowLoan);
    state.setToBorrowerCancelled();
  }

}
