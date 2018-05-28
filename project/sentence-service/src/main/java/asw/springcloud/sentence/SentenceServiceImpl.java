package asw.springcloud.sentence;

import asw.springcloud.sentence.wordclient.*;
import asw.springcloud.sentence.domain.Word;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SentenceServiceImpl implements SentenceService {

	VerbClient verbService;
	SubjectClient subjectService;
	ObjectClient objectService;


	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence =  
			String.format("%s %s %s %s %s.",
				subjectService.getWord().getString(),
				verbService.getWord().getString(),
				objectService.getWord().getString());
		return sentence;
	}

	@Autowired
	public void setVerbService(VerbClient verbService) {
		this.verbService = verbService;
	}

	@Autowired
	public void setSubjectService(SubjectClient subjectService) {
		this.subjectService = subjectService;
	}

	@Autowired
	public void setObjectService(ObjectClient objectService) {
		this.objectService = objectService;
	}
	
}
