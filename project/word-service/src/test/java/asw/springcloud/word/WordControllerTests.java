package asw.springcloud.word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.ActiveProfiles;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@IntegrationTest
@ActiveProfiles("test")
public class WordControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void subjectTest() throws Exception {
		mockMvc.perform(get("/test_subject"))//
		.andExpect(content().string(containsString("He")));
	}
	
	@Test
	public void objectTest() throws Exception {
		mockMvc.perform(get("/test_object"))//
		.andExpect(content().string(containsString("likes")));
	}
	
	@Test
	public void verbTest() throws Exception {
		mockMvc.perform(get("/test_verb"))//
		.andExpect(content().string(containsString("pizza")));
	}


}
