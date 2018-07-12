/**
 * 
 */
package com.vyom.generic.microservices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author Vyom
 *
 */
@Component
@RefreshScope
public class ZuulLoggingFilter extends ZuulFilter{

	private static final Logger LOG  = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		LOG.info(String.format("%s Request is : %s", request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
