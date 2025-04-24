package com.example.mcp_client_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@ComponentScan("com")
public class McpClientController {
	
	@Autowired
	ChatClient chatClient;
	
//	private final VertexAiGeminiChatModel chatModel;
//
//	public McpClientController(VertexAiGeminiChatModel chatModel) {
//		this.chatModel = chatModel;
//	}

	@RequestMapping("/weather")
	public String test(@RequestParam String city) {
		
		String prompt = String.format("Get Weather at  %s ", city);
		
		String response = chatClient.prompt(prompt).call().content().toString();
		return response;
	}
}