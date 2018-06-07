package asw.springcloud.sentence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import asw.springcloud.sentence.word.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.mock.mockito.MockBean;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SentenceControllerIntegrationTests {
	//Class under test:
	@MockBean
	private WordServiceHystrixImpl service;
	
	private RequestBuilder request;

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup() {
		// inizializzo le parti della frase
		when(service.getSubject()).thenReturn("This");
		when(service.getVerb()).thenReturn("is");
		when(service.getObject()).thenReturn("a test");
		
		//inizializzo la richiesta
		this.request = MockMvcRequestBuilders
				.get("/")
				.accept(MediaType.APPLICATION_JSON);
	}
	
	@Test
	public void testCorrect() {
		MvcResult result = mockMvc.perform(this.request)
				.andExpect(status().isOk())
				.andExpect(content().string("This is a test."))
				.andReturn();
	}
}