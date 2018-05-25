package asw.springcloud.sentence.wordclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("object")
public interface ObjectClient {

	@GetMapping(value="/")
	public String getWord(); 

	static class HystrixClientFallback implements ObjectiveClient {

		@Override

		public Word getWord() {

			return new Word();

		}	
	}	

}
