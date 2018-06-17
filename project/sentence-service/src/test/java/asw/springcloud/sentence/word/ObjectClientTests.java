package asw.springcloud.sentence.word;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ObjectClientTests {

	@Mock
	ObjectClient object;

	@InjectMocks
	private WordServiceHystrixImpl service;

	@Test
	public void testGetObject() {
		when(object.getWord()).thenReturn("a test");
		Assert.assertEquals("a test", service.getObject());
	}
}