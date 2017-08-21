package com.cz.coder.web.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * resposne 的包装类 ，用来替换filter中的
 * @author Administrator
 *
 */
public class StatusExposingServletResponse extends HttpServletResponseWrapper { 
			
		private int  httpStatus ; 
	
		public StatusExposingServletResponse(HttpServletResponse response) {
			super(response);
		}
		
		 @Override 
		 public void sendError(int sc) throws IOException { 
					httpStatus = sc; super.sendError(sc); 
		} 
		 @Override 
		 public void sendError(int sc, String msg) throws IOException {
					httpStatus = sc; super.sendError(sc, msg); 
		} 
		@Override 
		public void setStatus(int sc) { 
					httpStatus = sc; super.setStatus(sc); 
		} 
		
		public int getStatus(){
			return httpStatus;
		}
} 
			