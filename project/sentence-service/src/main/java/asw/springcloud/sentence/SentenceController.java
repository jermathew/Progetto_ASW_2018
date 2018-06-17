package asw.springcloud.sentence;

import asw.springcloud.sentence.word.WordService; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger; 

@RestController
public class SentenceController {

	private final Logger logger = Logger.getLogger("asw.springcloud.sentence"); 

	@Autowired 
	private WordService wordService;

	@RequestMapping("/")
	public String getSentence() {
		return wordService.buildSentence();
	}
	
}
