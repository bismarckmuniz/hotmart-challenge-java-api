package io.github.bismarckmuniz.productorjavaapi.util.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class that implements the necessary settings for the cache in the API.
 *  
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@EnableCaching
@Configuration
public class CacheConfiguration {

	/**
	 * Method that instantiates a cache manager based on ConcurrentMapCacheManager
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @return <code>CacheManagerCustomizer<ConcurrentMapCacheManager></code> object
	 */
	@Bean
	public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
		return new CacheManagerCustomizer<ConcurrentMapCacheManager>() {
			@Override
			public void customize(ConcurrentMapCacheManager cacheManager) {
				cacheManager.setAllowNullValues(true);
			}
		};
	}
}
