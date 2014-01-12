package com.changwon.junit.ch3;

public interface RequestHandler {
	Response process(Request request) throws Exception;
}
