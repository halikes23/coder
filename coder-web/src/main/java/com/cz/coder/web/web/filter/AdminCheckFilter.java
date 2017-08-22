package com.cz.coder.web.web.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cz.coder.web.service.LoginService;

import net.sf.json.JSONObject;

public class AdminCheckFilter implements Filter {

	private final static Logger logger = LoggerFactory
			.getLogger(AdminCheckFilter.class);
	/** * 要检查的session名称 */
	private String sessionkey;
	/** * 不拦截的url */
	private Pattern excepUrlPattern;
	/** * 不通过时转发的url */
	private String forwardUrl;

	
	private LoginService loginService ;
	
	private static final int SESSION_TIMEOUT = 14400 ;

	/**
	 * 初始化过滤器参数信息
	 */
	public void init(FilterConfig cfg) throws ServletException {

		ServletContext context = cfg.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		loginService = (LoginService) ac.getBean("loginService") ;

		logger.info("1");
		sessionkey = cfg.getInitParameter("sessionKey");
		// 初始化免过滤接口
		String excepUrlRegex = cfg.getInitParameter("excepUrlRegex");
		if (!StringUtils.isBlank(excepUrlRegex)) {
			excepUrlPattern = Pattern.compile(excepUrlRegex);
		}
		forwardUrl = cfg.getInitParameter("forwardUrl");
	}

	/**
	 * 执行过滤器
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		StatusExposingServletResponse response = new StatusExposingServletResponse(
				(HttpServletResponse) res);

		String servletPath = request.getServletPath();
		String servletUri = request.getRequestURI();
		String queryString = request.getQueryString();

		if (servletUri.contains(".")) {
			chain.doFilter(req, res);
			return;
		}
		
		chain.doFilter(req, res);
		
	}


	private void loadPostParams(ServletRequest req, HttpServletRequest request,
			JSONObject jsonRequest) throws Exception {

//		if (StringUtils.contains(request.getContentType(),
//				"multipart/form-data")) {
//			return;
//		}

//		InputStream stream = null;
//		StringBuilder sb = new StringBuilder();
//		StringBuilderWriter writer = new StringBuilderWriter(sb);
//		try {
//			stream = req.getInputStream();
//			byte[] buffer = new byte[1024];
//			int length;
//			while ((length = stream.read(buffer)) != -1) {
//				writer.write(new String(buffer, 0, length - 1));
//			}
//		} catch (Exception e) {
//			logger.error("", e);
//		} finally {
//			if (writer != null) {
//				writer.flush();
//				writer.close();
//			}
//		}
//
//		String params = new String(sb.toString().getBytes(), "UTF-8");
//
//		jsonRequest.put("params", params);
	}

	public void destroy() {
		// do nothing
	}
}
