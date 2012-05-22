package ${package}.controllers;

import org.jogger.config.DefaultControllerLoader;
import org.jogger.http.Response;
import org.jogger.test.JoggerTest;
import org.jogger.test.MockJoggerServlet;
import org.jogger.test.MockResponse;

import ${package}.interceptors.AppInterceptors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PagesTest extends JoggerTest {
	
	@Test
	public void shouldRenderIndex() throws Exception {
		
		MockResponse response = get("/").run();
		
		Assert.assertEquals( response.getStatus(), Response.OK );
		Assert.assertEquals( response.getRenderedTemplate(), "index.ftl" );
		Assert.assertTrue( response.getOutputAsString().contains("test") );
		
	}

	@Override
	protected MockJoggerServlet getJoggerServlet() {
		
		MockJoggerServlet joggerServlet = new MockJoggerServlet();
		joggerServlet.setBasePackage("${package}.controllers");
		joggerServlet.setInterceptors( new AppInterceptors() );
		
		return joggerServlet;
		
	}

}