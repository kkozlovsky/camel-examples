package example1.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

	public static void main(String[] args) {

		CamelContext camelContext = new DefaultCamelContext();
		try {
			camelContext.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("file:data/input?noop=true")
							.to("log:?level=INFO&showBody=true&showHeaders=true")
							.to("file:data/output"); // будет создана, если не существует
				}
			});
			
			camelContext.start();
			Thread.sleep(1000);
			camelContext.stop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
