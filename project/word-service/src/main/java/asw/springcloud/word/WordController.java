package asw.springcloud.word;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@RestController
public class WordController {

	@Value("${words}") 
	/* le parole di questo tipo */ 
	private String words;
	
	private final Logger logger = Logger.getLogger("asw.springcloud.word"); 

	@GetMapping("/")
	public Word getWord() {
		return new Word(words[random.nextInt(words.length)]);
	}
}
