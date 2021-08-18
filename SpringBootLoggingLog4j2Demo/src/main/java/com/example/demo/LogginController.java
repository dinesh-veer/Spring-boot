package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogginController {

	Logger logger = LoggerFactory.getLogger(LogginController.class);
	
	@GetMapping("/")
	public String getMessage() {
		logger.trace("Trace Message");
		logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		return "Test";
	}
}
