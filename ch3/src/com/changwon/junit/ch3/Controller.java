package com.changwon.junit.ch3;

import org.omg.CORBA.portable.ResponseHandler;

public interface Controller {
	Response processRequest(Request request);
	void addHandler(Request request, ResponseHandler requestHandler);
}
