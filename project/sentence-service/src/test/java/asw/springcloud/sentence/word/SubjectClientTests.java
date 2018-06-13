package asw.springcloud.sentence.word;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SubjectClientTests {

	@Mock
	SubjectClient subject;

	@InjectMocks
	private WordServiceHystrixImpl service;

	@Test
	public void testGetSubject() {
		when(subject.getWord()).thenReturn("This");
		Assert.assertEquals("This", service.getSubject());
	}
}