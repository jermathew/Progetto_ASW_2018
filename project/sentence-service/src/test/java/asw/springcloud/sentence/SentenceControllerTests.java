package asw.springcloud.sentence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import asw.springcloud.sentence.word.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class SentenceControllerTests {
	//Class under test:
	WordServiceHystrixImpl service;

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
		Mockito.when(subject.getWord()).thenReturn("1");
		Mockito.when(verb.getWord()).thenReturn("2");
		Mockito.when(object.getWord()).thenReturn("3");
	}

	@Test
	public void test() {
		//	We should get the sentence built in the correct order:
		Assert.assertEquals("1 2 3.", service.buildSentence());
	}
}