package Phase1.Users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@Configuration
//@EnableRedisHttpSession
public class RedisConfig { // LETTICE AND REDISACTION CONFIGS FOR MANUSALLY CONFIGURATION BEANS FOR REDIS SESSSION AND CACHE MANAGEMENT
	
	    @Bean
	    public LettuceConnectionFactory connectionFactory() {
	        return new LettuceConnectionFactory(); 
	    }
	    @Bean
	    public ConfigureRedisAction configureRedisAction() {
	        return ConfigureRedisAction.NO_OP;
	    }
	    

	
}
