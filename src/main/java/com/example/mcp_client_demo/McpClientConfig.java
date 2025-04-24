package com.example.mcp_client_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpClientConfig {
	
	@Bean
	ToolCallbackProvider toolCallbackProvider() {
		return new SyncMcpToolCallbackProvider();
	}
	
	@Bean
	ChatClient chatClient(VertexAiGeminiChatModel chatModel, ToolCallbackProvider toolCallbackProvider) {
		return ChatClient.builder(chatModel).defaultTools(toolCallbackProvider.getToolCallbacks()).build();
	}

}
