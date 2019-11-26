package com.redteamobile.servicecomb_base;

import org.apache.servicecomb.tracing.zipkin.EnableZipkinTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;

@SpringBootApplication
@EnableServiceComb
@EnableZipkinTracing
public class ServicecombBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicecombBaseApplication.class, args);
	}
}
