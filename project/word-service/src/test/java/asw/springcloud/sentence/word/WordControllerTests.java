package asw.springcloud.sentence.word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordControllerTests {

	@Mock
	WordController controller;

	@Test
	public void testGetWord() throws Exception{
		when(controller.getWord()).thenReturn("This");
		assertEquals("This",controller.getWord());
	}
}
