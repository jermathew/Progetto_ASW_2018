package asw.springcloud.sentence.word;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class VerbClientTests {

	@Mock
	VerbClient verb;

	@InjectMocks
	private WordServiceHystrixImpl service;

	@Test
	public void testGetVerb() {
		when(verb.getWord()).thenReturn("is");
		Assert.assertEquals("is", service.getVerb());
	}
}