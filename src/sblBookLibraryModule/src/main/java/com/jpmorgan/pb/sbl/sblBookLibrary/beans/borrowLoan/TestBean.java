package com.jpmorgan.pb.sbl.sblBookLibrary.beans.borrowLoan;

import javax.ejb.Remote;

@Remote
public interface TestBean {
  String returnSomeMessage();
}
