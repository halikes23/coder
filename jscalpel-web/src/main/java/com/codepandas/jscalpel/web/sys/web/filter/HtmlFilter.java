package com.codepandas.jscalpel.web.sys.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.Filter;


public class HtmlFilter implements Filter{
	
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		MyHtmlRequest myrequest = new MyHtmlRequest(request);
		chain.doFilter(myrequest, response);
	}
	
	public void init(FilterConfig filterConfig)throws ServletException{
		
	}
	
	public void destroy() {
		
	}
	
	class MyHtmlRequest extends HttpServletRequestWrapper  {
		
		private HttpServletRequest request;
		
		public  MyHtmlRequest(HttpServletRequest request) {
		      super(request);
		      this.request = request;
		}
		 
        @Override
        public String getParameter(String name ) {
        	
          if (name == null) {
              return null;
          }
      	  String value = request.getParameter(name);
	      if (value == null ) {
			  return null ; 
		  }
         //调用filter转义value中的html标签
          return filter(value);
        }
		
        public String filter (String value){
        	char content[] = new char[value.length()];
        	value.getChars(0, value.length(), content, 0);
        	StringBuffer result = new StringBuffer(content.length + 50);
        	for (int i = 0; i < content.length; i++) {
        		switch (content[i]) {
        		case '<':
        			result.append("");
        			break ;
        		case '>': 
        			result.append("");
        			break ;
        		default: 
        			result.append(content[i]);	
        		}
        	}
        	 return result.toString();
        }
	}
	
	
	
}
