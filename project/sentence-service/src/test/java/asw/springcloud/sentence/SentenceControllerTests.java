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

@RunWith(SpringRunner.class)
@SpringBootTest
public class SentenceControllerTests {
	//Class under test:
	private WordServiceHystrixImpl service;

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup() {

		service = new WordServiceHystrixImpl();
		
		//	Establish Mock Dependencies:
		SubjectClient subject = Mockito.mock(SubjectClient.class);
		VerbClient verb = Mockito.mock(VerbClient.class);
		ObjectClient object = Mockito.mock(ObjectClient.class);

		service.setSubject(subject);
		service.setVerb(verb);
		service.setObject(object);
		
		//	Describe Mock Behaviors:
		Mockito.when(subject.getWord()).thenReturn("This");
		Mockito.when(verb.getWord())	.thenReturn("is");
		Mockito.when(object.getWord()).thenReturn("a test");
	}
	
	@Test
	public void testCorrect() {
		//	We should get the sentence built in the correct order:
		Assert.assertEquals("This is a test.", service.buildSentence());
	}
	
	@Test
	public void testUncorrect1() {
		Assert.assertNotEquals("This is atest.", service.buildSentence());
	}
	
	@Test
	public void testUncorrect2() {
		Assert.assertNotEquals("This is a test", service.buildSentence());
	}
}