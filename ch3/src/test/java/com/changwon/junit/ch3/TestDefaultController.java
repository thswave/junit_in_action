package com.changwon.junit.ch3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestDefaultController {

	private DefaultController controller;
	private Request request;
	private RequestHandler handler;

	@Before
	public void instantiate() throws Exception {
		controller = new DefaultController();
		request = new SampleRequest();
		handler = new SampleHandler();
		controller.addHandler(request, handler);
	}

	@Test
	public void testAddHandler() {
		RequestHandler handler2 = controller.getHandler(request);
		assertSame(
				"Handler we set in controller should be the same handler we get",
				handler2, handler);

	}
	
	@Test(expected=RuntimeException.class)
	public void testGetHandlerNotDefined(){
		SampleRequest request = new SampleRequest("testNotDefined");
		
		// RuntimeException point
		controller.getHandler(request);
	}
	
	@Test(expected=RuntimeException.class)
	public void testAddRequestDuplicateName(){
		SampleRequest request = new SampleRequest();
		SampleHandler handler = new SampleHandler();
		
		// RuntimeException point
		controller.addHandler(request, handler);
	}

	@Test
	public void testProcessRequest() {
		Response response = controller.processRequest(request);
		assertNotNull("Must not return a null response", response);
		assertEquals("Response should be of type SampleResponse",
				SampleResponse.class, response.getClass());
	}
	
	@Test
	public void testProcessAnswersErrorsResponse(){
		SampleRequest request = new SampleRequest("testError");
		SampleExceptionHandler handler = new SampleExceptionHandler();
		controller.addHandler(request, handler);
		Response response = controller.processRequest(request);
		assertNotNull("Must not return a null response", response);
		assertEquals(ErrorResponse.class, response.getClass());
	}
	
	@Test(timeout=130)
	@Ignore(value="Ignore for now until we decide a decent time-limit")
	public void testProcessMultipleRequestsTimeout(){
		Request request;
		Response response;
		RequestHandler handler = new SampleHandler();
		for (int i = 0; i < 99999; i++) {
			request = new SampleRequest(String.valueOf(i));
			controller.addHandler(request, handler);
			response = controller.processRequest(request);
			assertNotNull(response);
			assertNotSame(ErrorResponse.class, response.getClass());
		}
	}

	private class SampleRequest implements Request {

		private static final String NAME = "Test";
		private String name;
		
		public SampleRequest(){
			this(NAME);
		}
		
		public SampleRequest(String name){
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
	}

	private class SampleHandler implements RequestHandler {

		@Override
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}

	private class SampleResponse implements Response {
		private static final String NAME = "Test";
		
		public SampleResponse(){}
		
		public String getName(){
			return NAME;
		}
		
		@Override
		public boolean equals(Object object){
			boolean result = false;
			if (object instanceof SampleResponse){
				result = ((SampleResponse) object).getName().equals(getName());
			}
			return result;
		}
		
		@Override
		public int hashCode(){
			return NAME.hashCode();
		}
	}
	
	private class SampleExceptionHandler implements RequestHandler{

		@Override
		public Response process(Request request) throws Exception {
			throw new Exception("error processing request");
		}
		
	}
}
