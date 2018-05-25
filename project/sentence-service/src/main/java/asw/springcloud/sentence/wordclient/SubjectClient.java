package asw.springcloud.sentence.wordclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("subject")
public interface SubjectClient {

	@GetMapping(value="/")
	public String getWord(); 

}
