package asw.springcloud.word.controller;

import asw.springcloud.word.domain.Word;
import java.util.Random;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@RestController
public class WordController {
    private final Random random = new Random();


	@Value("${words}") 
	/* le parole di questo tipo */ 
	private String[] words;
	
	private final Logger logger = Logger.getLogger("asw.springcloud.word"); 

	@GetMapping("/")
	public String getWord() {
		return new Word(words[random.nextInt(words.length)]).getString();
	}
	@GetMapping("/word-json")
	public Word getJSONWord() {
		return new Word(words[random.nextInt(words.length)]);
	}
}
