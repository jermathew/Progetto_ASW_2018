package asw.springcloud.sentence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnitClassRunner;
import org.junit.Before;
import org.junit.Ignore;
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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {""})
@WebAppConfiguration
@Ignore
public class SentenceControllerIntegrationTests {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
	    ServletContext servletContext = wac.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    //Assert.assertNotNull(wac.getBean("sentenceController"));
	}
	
	@Test
	public void givenHomePageURI_whenMockMVC_thenReturnsIndexViewName() {
	    this.mockMvc.perform(get("/sentence")).andDo(print())
	     .andExpect(view().name("index"));
	}
	
	@Test
	public void givenSentenceURI_whenMockMVC_thenVerifyResponse() {
	    MvcResult mvcResult = this.mockMvc.perform(get("/sentence"))
	      .andDo(print()).andExpect(status().isOk())
	      //.andExpect(jsonPath("$.message").value("Hello World!!!"))
	      .andReturn();
	     
	    Assert.assertEquals("application/json;charset=UTF-8", 
	      mvcResult.getResponse().getContentType());
	}
	
	@Test
	public void givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() {
	    this.mockMvc
	      .perform(get("/greetWithPathVariable/{name}", "John"))
	      .andDo(print()).andExpect(status().isOk())
	       
	      .andExpect(content().contentType("application/json;charset=UTF-8"))
	      .andExpect(jsonPath("$.message").value("Hello World John!!!"));
	}
	
	@Test
	public void givenGreetURIWithQueryParameter_whenMockMVC_thenResponseOK() {
	    this.mockMvc.perform(get("/greetWithQueryVariable")
	      .param("name", "John Doe")).andDo(print()).andExpect(status().isOk())
	      .andExpect(content().contentType("application/json;charset=UTF-8"))
	      .andExpect(jsonPath("$.message").value("Hello World John Doe!!!"));
	}
}