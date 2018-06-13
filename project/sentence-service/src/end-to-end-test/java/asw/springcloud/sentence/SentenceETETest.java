package asw.springcloud.sentence;

import org.junit.Assert;
import org.junit.Test;
import com.github.kevinsawicki.http.*;


public class SentenceETETest {


	@Test
	public void testGetSentence() {
		
		String response = HttpRequest.get("http://google.com").body();
		System.out.println("Response was: " + response);
		String[] res = response.split(" ");
		Assert.assertEquals(3, res.length);
	}
}