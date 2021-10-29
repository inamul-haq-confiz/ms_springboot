package com.photoapp.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class PhotoAppApiGatewayApplication {

	public static void main(String[] args) {
		//HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);

		SpringApplication.run(PhotoAppApiGatewayApplication.class, args);
	}

}
