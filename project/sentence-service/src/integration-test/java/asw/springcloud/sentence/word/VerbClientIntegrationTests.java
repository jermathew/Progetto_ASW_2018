package asw.springcloud.sentence.word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import asw.springcloud.sentence.word.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "words = foo,baz,boh")
@AutoConfigureMockMvc
public class VerbClientIntegrationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetObject() throws Exception {
		mockMvc.perform(get("/verb"))
		.andExpect(status().isOk())
		.andExpect(content().string(anyOf(is("foo"),is("baz"),is("boh"))));
	}
}