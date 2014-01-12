package com.changwon.junit.ch3;

public class ErrorResponse implements Response {
	private Request originalRequest;
	private Exception originalException;
	
	public ErrorResponse(Request originalRequest, Exception originalException) {
		super();
		this.originalRequest = originalRequest;
		this.originalException = originalException;
	}

	public Request getOriginalRequest() {
		return originalRequest;
	}

	public Exception getOriginalException() {
		return originalException;
	}
	
	
}
