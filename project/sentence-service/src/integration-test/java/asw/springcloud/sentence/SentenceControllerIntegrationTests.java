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
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;
import org.mockito.Mockito;
import asw.springcloud.sentence.word.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@Ignore
public class SentenceControllerIntegrationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private SubjectClient subject;
	@Mock
	private VerbClient verb;
	@Mock
	private ObjectClient object;
	
	@InjectMocks
	private WordServiceHystrixImpl service;
	
	@Before
	public void setup() throws Exception {
		when(subject.getWord()).thenReturn("This");
		when(verb.getWord()).thenReturn("is");
		when(object.getWord()).thenReturn("a test");	}
	
	@Test
	public void testGetSentence() throws Exception {
		mockMvc.perform(get("/sentence"))
		.andExpect(status().isOk())
		.andExpect(content().string("This is a test."));
	}
}