package com.jpmorgan.pb.sbl.sblBookLibrary.model.borrowLoan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractBorrowLoanState implements BorrowLoanState {

  private final Logger log = LoggerFactory.getLogger(this.getClass());
  
  protected void logWarningAndThrowException(final String ERROR_MSG) throws IllegalStateChangeException {
    log.warn(ERROR_MSG);
    throw new IllegalStateChangeException(ERROR_MSG);
  }
}
