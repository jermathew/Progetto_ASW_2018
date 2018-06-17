package asw.springcloud.sentence;

import org.junit.Assert;
import org.junit.Test;
import com.github.kevinsawicki.http.*;


public class SentenceETETest {


	@Test
	public void testGetSentence() {
		
		String response = HttpRequest.get("http://ec2-18-191-110-245.us-east-2.compute.amazonaws.com").body();
		System.out.println("Response was: " + response);
		String[] res = response.split(" ");
		Assert.assertEquals(3, res.length);
	}
}
