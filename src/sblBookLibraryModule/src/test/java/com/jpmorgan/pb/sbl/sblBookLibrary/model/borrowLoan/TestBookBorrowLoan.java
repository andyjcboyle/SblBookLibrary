package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestBookBorrowLoan {

  @Test
  public void testCreateBasicBorrowLoan() {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    assertTrue("The BorrowLoan should not be null", borrowLoan != null); 
  }
  
  @Test
  public void testDefaultSetupOfBookBorrowLoan() {
    BookBorrowLoan borrowLoan = new BookBorrowLoan();
    assertEquals("Lender should be null", borrowLoan.getLender(), null);
    assertEquals("Borrower should be null", borrowLoan.getBorrower(), null);
    assertEquals("Book should be null", borrowLoan.getBook(), null);
    assertEquals("Trade agreed date should be null", borrowLoan.getTradeAgreedDate(), null);
    assertEquals("Borrow Loan start date should be null", borrowLoan.getBorrowLoanStartDate(), null);
    assertEquals("Borrow LOan end date should be null", borrowLoan.getBorrowLoanEndDate(), null);
  }
}
