package eu.icya.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import eu.icya.sblBookLibrary.model.borrowLoan.AbstractBorrowLoanState;
import eu.icya.sblBookLibrary.model.borrowLoan.BookBorrowLoan;
import eu.icya.sblBookLibrary.model.borrowLoan.ConfirmedInPrincipleState;
import eu.icya.sblBookLibrary.model.borrowLoan.IllegalStateChangeException;

public class TestConfirmedInPrincipleState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToPreInitialise();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToInitialised();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToProposedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToProposed();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToConfirmedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToConfirmedInPrinciple();
  }
  
  @Test
  public void testCanMoveToDeclinedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToLoanerDeclined();
  }

  @Test
  public void testCanMoveToActiveState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToActive();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToOverdue();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToReturnedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToBookReturned();
  }

  @Test
  public void testCanMoveToCancelledState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ConfirmedInPrincipleState(borrowLoan);
    state.setToBorrowerCancelled();
  }



}
