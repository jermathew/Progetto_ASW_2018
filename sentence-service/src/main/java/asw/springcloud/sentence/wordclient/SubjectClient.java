package asw.springcloud.sentence.wordclient;

import asw.springcloud.sentence.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("subject")
public interface SubjectClient {

	@GetMapping(value="/")
	public Word getWord(); 

}
