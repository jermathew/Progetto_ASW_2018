package asw.springcloud.word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Ignore;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "words = foo,bar,baz")
@AutoConfigureMockMvc
public class WordControllerTests {

	@Autowired
	MockMvc mockMvc;


	@Test
	public void words() throws Exception {
		mockMvc.perform(get("/"))//
				.andExpect(jsonPath("$.word", anyOf(is("foo"), is("bar"), is("baz"))));
	}

}
