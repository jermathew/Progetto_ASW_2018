package asw.springcloud.sentence.word;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@RestController
public class WordController {

	@Value("${words}") 
	/* le parole di questo tipo */ 
	private String[] words;
	
	private final Logger logger = Logger.getLogger("asw.springcloud.word"); 

	@RequestMapping("/")
	public String getWord() {
		/* restituisce una parola a caso tra le parole di questo tipo */ 
		int i = (int) (Math.round(Math.random()*(words.length-1)));
		String word = words[i];
		logger.info("getWord(): " + word);
		return word; 
	}
}
