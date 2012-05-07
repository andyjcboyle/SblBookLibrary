package com.jpmorgan.pb.sbl.sblBookLibrary.api.services;

import javax.ejb.Remote;

@Remote
public interface TestBean {
  String returnSomeMessage();
}
