package asw.springcloud.sentence.wordclient;

import asw.springcloud.sentence.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("object")
public interface ObjectClient {

	@GetMapping("/")
	public Word getWord(); 

	
	static class HystrixClientFallback implements ObjectClient {

		@Override

		public Word getWord() {

			return new Word();

		}	
	}	

}
