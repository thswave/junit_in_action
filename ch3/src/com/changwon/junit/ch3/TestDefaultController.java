package com.changwon.junit.ch3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestDefaultController {

	@SuppressWarnings("unused")
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
	@Ignore
	public void testMethod() {
		throw new RuntimeException("implement me");
	}

	@Test
	public void testAddHandler() {
		RequestHandler handler2 = controller.getHandler(request);
		assertSame(
				"Handler we set in controller should be the same handler we get",
				handler2, handler);

	}

	@Test
	public void testProcessRequest() {
		Response response = controller.processRequest(request);
		assertNotNull("Must not return a null response", response);
		assertEquals("Response should be of type SampleResponse",
				SampleResponse.class, response.getClass());
	}

	private class SampleRequest implements Request {

		@Override
		public String getName() {
			return "Test";
		}
	}

	private class SampleHandler implements RequestHandler {

		@Override
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}

	private class SampleResponse implements Response {

	}
}
