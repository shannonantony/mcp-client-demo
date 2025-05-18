package com.example.mcp_client_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.modelcontextprotocol.client.McpSyncClient;

@Configuration
@Controller
@ResponseBody
public class McpClientController {
	

	ChatClient ai;
	
	McpClientController(McpSyncClient client,
		      ChatClient.Builder ai) {
		
		
		var system = """
		        You are an AI powered assistant to help find the weather of a city.
		        """;
		    this.ai = ai
		        .defaultSystem(system)
		        .defaultToolCallbacks(new SyncMcpToolCallbackProvider(client))
		        .build();
	}


	@RequestMapping("/weather")
	public String test(@RequestParam String city) {
		
		String prompt = String.format("Get Weather at  %s ", city);
		
		String response = ai.prompt(prompt).call().content();
		return response;
	}
}