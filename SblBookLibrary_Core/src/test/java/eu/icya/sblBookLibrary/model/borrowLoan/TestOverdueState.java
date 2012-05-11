package eu.icya.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import eu.icya.sblBookLibrary.model.borrowLoan.AbstractBorrowLoanState;
import eu.icya.sblBookLibrary.model.borrowLoan.BookBorrowLoan;
import eu.icya.sblBookLibrary.model.borrowLoan.IllegalStateChangeException;
import eu.icya.sblBookLibrary.model.borrowLoan.OverdueState;

public class TestOverdueState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToPreInitialise();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToInitialised();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToProposedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToProposed();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToConfirmedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToConfirmedInPrinciple();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToDeclinedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToLoanerDeclined();
  }

  @Test
  public void testCanMoveToActiveState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToActive();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToOverdue();
  }

  @Test
  public void testCanMoveToReturnedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToBookReturned();
  }

  @Test(expected = IllegalStateChangeException.class)
  public void testCannotMoveToCancelledState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new OverdueState(borrowLoan);
    state.setToBorrowerCancelled();
  }

}
