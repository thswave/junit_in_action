package com.changwon.junit.ch3;


public interface Controller {
	Response processRequest(Request request);
	void addHandler(Request request, RequestHandler requestHandler);
}
