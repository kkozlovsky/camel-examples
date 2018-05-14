package example2.direct;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
		return new SampleMockRoute();
	}

	@Test
	public void sampleRouteTest() throws InterruptedException {

		String expected = "Как дела?";

		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);

		template.sendBody("direct:sampleInput","Как дела?" );
		assertMockEndpointsSatisfied();
		
	}

}