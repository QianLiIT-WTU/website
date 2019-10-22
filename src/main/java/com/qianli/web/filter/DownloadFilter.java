package com.qianli.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianli.pojo.Users;

/*
 * 过滤器，只有会员才可下载
 * 
 */
@WebFilter(urlPatterns= {"/source/downloadPic","/source/downloadFic","/source/downlodVic"})
public class DownloadFilter implements Filter {
 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		Users  user=(Users) session.getAttribute("user");
		if(user.getRoot()<=2){
			// 没有登录
			
			request.setAttribute("msg","该资源仅千里会员才可下载");
			request.getRequestDispatcher("/view/jsp/Msg.jsp").forward(request, response);;
			
		}else{
			// 已经登录，继续请求下一级资源（继续访问）
			arg2.doFilter(arg0, arg1);
		}
		
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}