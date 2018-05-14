package example1.file;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFilesRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new CopyFilesRoute();
	}
	
	@Test
	public void checkFileExistsInOutputDirectory() throws InterruptedException {

		Thread.sleep(5000);
		File file = new File("data/output");
		assertTrue(file.isDirectory());
		System.out.println("Файлов в директории : " + file.listFiles().length);
		assertEquals(2, file.listFiles().length);
	}
}
