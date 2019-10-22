package com.qianli.web.websocket;

import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.qianli.pojo.Users;





/**
 * 此类用来获取登录用户信息并交由websocket管理
 *  websocket的链接建立是基于http握手协议，我们可以添加一个拦截器处理握手之前和握手之后过程
 * @author ts
 *
 */


public class MyWebSocketInterceptor implements HandshakeInterceptor{
		
	@Override
	public boolean beforeHandshake(ServerHttpRequest request,ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		//将ServerHttpRequest转换成request请求相关的类，用来获取request域中的用户信息	
		if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
      
				Users user=(Users)session.getAttribute("user");
				
			if(user!=null){
				//获取登录的用户
				//将用户放入socket处理器的会话(WebSocketSession)中				
				attributes.put("user", user);
				System.out.println("Websocket:用户[ID:" + (user.getUid() + ",Name:"+user.getUsername()+"]要建立连接"));
			}else{
				//用户没有登录，拒绝聊天
				//握手失败！
				System.out.println("--------------握手已失败...");
				
				return false;
			}
			
		}
		System.out.println("--------------握手开始...");
		return true;
	}
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		System.out.println("--------------握手成功啦...");
	}
}