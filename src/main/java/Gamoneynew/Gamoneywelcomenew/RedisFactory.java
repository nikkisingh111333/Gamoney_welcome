package Gamoneynew.Gamoneywelcomenew;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
@Configuration
@EnableRedisHttpSession
public class RedisFactory {
   @Value("${spring.redis.host}")
   private String redis_host;
	@Bean //MOST IMPOTATN IF WE WANT TO CONNECT TO DOCKER WITH REDIS
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redis_host);
        redisStandaloneConfiguration.setPort(6379);

	    return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	@Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
	@Bean
	@Qualifier("redisUserTemplate")
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
}
