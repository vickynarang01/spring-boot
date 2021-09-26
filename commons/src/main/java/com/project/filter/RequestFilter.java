package com.project.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class RequestFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
			String corelationId = request.getHeader("Correlation-Id");
			if(null==corelationId){
				corelationId=String.valueOf(UUID.randomUUID());
			}
			requestWrapper.addHeader("Correlation-Id",corelationId);
			MDC.put("mdcData", corelationId);
			filterChain.doFilter(requestWrapper, servletResponse);
		} finally {
			MDC.clear();
		}

	}



	@Override
	public void destroy() {

	}
}
