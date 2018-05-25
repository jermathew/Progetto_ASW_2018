package asw.springcloud.sentence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Ignore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import demo.dao.AdjectiveDaoImpl;
import demo.dao.ArticleDaoImpl;
import demo.dao.NounDaoImpl;
import demo.dao.SubjectDaoImpl;
import demo.dao.VerbDaoImpl;
import demo.dao.WordDao;
import demo.domain.Word;

public class SentenceServiceImplTest {

	//	Class under test:
	SentenceServiceImpl service;
	
	@Before
	public void setup() {

		service = new SentenceServiceImpl();
		
		//	Establish Mock Dependencies:
		SubjectClient subject = Mockito.mock(SubjectClient.class);
		VerbClient verb = Mockito.mock(VerbClient.class);
		ObjectClient object = Mockito.mock(ObjectClient.class);

		service.setSubjectService(subject);
		service.setVerbService(verb);
		service.setObjectService(object);
		
		//	Describe Mock Behaviors:
		Mockito.when(subject.getWord()).thenReturn(new Word("1"));
		Mockito.when(verb.getWord()).thenReturn(new Word("2"));
		Mockito.when(object.getWord()).thenReturn(new Word("3"));
	}
	
	@Test
	public void test() {
		//	We should get the sentence built in the correct order:
		Assert.assertEquals("1 2 3.", service.buildSentence());
	}

}
