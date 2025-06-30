package com.ServiceRegistry__Nikee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryNikeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryNikeeApplication.class, args);
	}

}
