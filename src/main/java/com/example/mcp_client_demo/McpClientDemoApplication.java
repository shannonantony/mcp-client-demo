package com.example.mcp_client_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;

@SpringBootApplication
public class McpClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpClientDemoApplication.class, args);
	}
	
	 @Bean
	  McpSyncClient mcpSyncClient() {
	    var mcp = McpClient
	        .sync(HttpClientSseClientTransport.builder("http://localhost:8081").build())
	        .build();
	    mcp.initialize();
	    return mcp;
	  }

}
