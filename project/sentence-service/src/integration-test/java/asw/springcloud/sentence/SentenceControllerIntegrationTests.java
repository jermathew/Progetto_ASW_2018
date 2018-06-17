package asw.springcloud.sentence;

import asw.springcloud.sentence.word.ObjectClient;
import asw.springcloud.sentence.word.SubjectClient;
import asw.springcloud.sentence.word.VerbClient;
import asw.springcloud.sentence.word.WordServiceHystrixImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


/*@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@Ignore */
@RunWith(MockitoJUnitRunner.class)
public class SentenceControllerIntegrationTests {
	/*@Autowired
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
	}*/

	@Mock
	SubjectClient subject;
	@Mock
	VerbClient verb;
	@Mock
	ObjectClient object;

	@InjectMocks
	private WordServiceHystrixImpl service;

	@Test
	public void testGetSentence() {
		when(subject.getWord()).thenReturn("This");
		when(verb.getWord()).thenReturn("is");
		when(object.getWord()).thenReturn("a test");

		Assert.assertEquals("This is a test.", service.buildSentence());
	}
}