package asw.springcloud.sentence;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.logging.Logger; 

@Controller
public class SentenceController {

	@Autowired SentenceService sentenceService;

	private final Logger logger = Logger.getLogger("asw.springcloud.sentence"); 


	/**
	 * Display a small list of Sentences to the caller:
	 */
	@GetMapping("/")
	public @ResponseBody String getSentence() {
		String sentence= "<h3>A Sentence</h3><br/>" +	  
		sentenceService.buildSentence() + "<br/><br/>";
		logger.info("getSentence(): " + sentence);
		return sentence;
	}

}
