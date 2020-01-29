package com.tmanager.module.web.filter;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class TimeoutFilter extends OncePerRequestFilter{

	@Value("${module.timeoutValue}")
	private Integer timeoutValue;
	
	@Value("${module.threadPool}")
	private Integer threadPool;
		
	private Boolean completed = false;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		initCompletedFlag();
		
		ScheduledExecutorService timeoutsPool = Executors.newScheduledThreadPool(threadPool);
		
		Thread requestHandlingThread = Thread.currentThread();
		
		 ScheduledFuture<?> timeout = timeoutsPool.schedule(() -> {	
			if(!completed) {
				completed = true;
                requestHandlingThread.interrupt();
            }
		}, timeoutValue, TimeUnit.MILLISECONDS);
				
		try {
			filterChain.doFilter(request, response);
			timeout.cancel(false);
        } finally {
            completed = true;
        }
	}
	
	private void initCompletedFlag() {
		completed = false;
	}
}
