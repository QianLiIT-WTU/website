package com.qianli.web.websocket;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;




@Component("webSocketConfig")
//配置开启WebSocket服务用来接收ws请求
@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	
	 @Bean	
	    public WebSocketHandler WebSocketPushHandler(){
	        return new WebSocketPushHandler();
	    }

	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {    
    	        //1.注册WebSocket  
    	        String websocket_url = "/websocket/socketServer";                        //设置websocket的地址  
    	        registry.addHandler(WebSocketPushHandler(), websocket_url).                          //注册Handler  
    	                addInterceptors(new MyWebSocketInterceptor());                   //注册Interceptor  
    	  
    	        //2.注册SockJS，提供SockJS支持(主要是兼容ie8)  
    	        String sockjs_url = "/sockjs/socketServer";                              //设置sockjs的地址  
    	        registry.addHandler(WebSocketPushHandler(), websocket_url).                          //注册Handler  
                addInterceptors(new MyWebSocketInterceptor()) .                   //注册Interceptor  
    	                withSockJS();                                                           //支持sockjs协议  
    	   
 	
	}   	

	
}
