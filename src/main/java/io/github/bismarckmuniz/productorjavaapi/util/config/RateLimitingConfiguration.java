package io.github.bismarckmuniz.productorjavaapi.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.github.bismarckmuniz.productorjavaapi.util.interceptor.RateLimitInterceptor;

/**
 * Class that implements the necessary settings for the rate limiting in the API
 *  
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Configuration
public class RateLimitingConfiguration implements WebMvcConfigurer {
	
	private RateLimitInterceptor interceptor;
	
	@Autowired
	public RateLimitingConfiguration(RateLimitInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	/**
	 * Method that allow intercepting routes for rate limiting
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 */
	@Override 
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/productor/v1/transactions/**",
        		"/productor/v1/statistics/**");
    }

}
