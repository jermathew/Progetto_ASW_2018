package com.group;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProvaController {
	
	@Value("${hello.word}") 
	private String hello;

	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return "Dai un saluto al mondo: "+hello; 
	}
}