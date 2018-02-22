package com.lgh.springcloud.ribbon.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello() {
		long start = System.currentTimeMillis();

		String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

		long end = System.currentTimeMillis();
		log.info("Spend time: {}", end - start);

		return result;
	}

	public String helloFallback() {
		return "error";
	}
}
