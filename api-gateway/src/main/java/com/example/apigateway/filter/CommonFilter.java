package com.example.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;

@Configuration
public class CommonFilter implements GlobalFilter{
	Logger logging=LoggerFactory.getLogger(CommonFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request=exchange.getRequest();
		logging.info("request with Authorization="+request.getHeaders().getFirst("Authorization"));
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse response=exchange.getResponse();
			logging.info("response code="+response.getStatusCode());
		}));
			
	
	}

}
