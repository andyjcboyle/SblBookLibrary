package eu.icya.sblBookLibrary.model.borrowLoan;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import eu.icya.sblBookLibrary.model.borrowLoan.AbstractBorrowLoanState;
import eu.icya.sblBookLibrary.model.borrowLoan.BookBorrowLoan;
import eu.icya.sblBookLibrary.model.borrowLoan.IllegalStateChangeException;
import eu.icya.sblBookLibrary.model.borrowLoan.ProposedState;

public class TestProposedState {

  BookBorrowLoan borrowLoan;

  @Before
  public void setup() {
    borrowLoan = mock(BookBorrowLoan.class);
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToPreInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToPreInitialise();
  }
  
  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToInitialisedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToInitialised();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToProposedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToProposed();
  }
  
  @Test
  public void testCanMoveToConfirmedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToConfirmedInPrinciple();
  }
  
  @Test
  public void testCanMoveToDeclinedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToLoanerDeclined();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToActiveState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToActive();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToOverdueState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToOverdue();
  }

  @Test(expected=IllegalStateChangeException.class)
  public void testCannotMoveToReturnedState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToBookReturned();
  }

  @Test
  public void testCanMoveToCancelledState() throws IllegalStateChangeException {
    AbstractBorrowLoanState state = new ProposedState(borrowLoan);
    state.setToBorrowerCancelled();
  }



}
