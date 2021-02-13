package Gamoneynew.Gamoneywelcomenew;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;
@EnableCaching
@Configuration
public class CacheConfiguration {
    
	@Bean
	public EhCacheCacheManager cacheManager() {
		return new EhCacheCacheManager(cacheManageFactory().getObject());
	}
	public EhCacheManagerFactoryBean cacheManageFactory() {
		EhCacheManagerFactoryBean eh=new EhCacheManagerFactoryBean();
		eh.setConfigLocation(new ClassPathResource("ehcache.xml")); //we need to create this xml file in our classpath
		eh.setShared(true);
		
		return eh;
	}
}
