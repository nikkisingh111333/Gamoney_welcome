package Gamoneynew.Gamoneywelcomenew;


import java.io.File;
import java.io.FileInputStream;
import org.apache.http.client.*;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Properties;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//import com.netflix.discovery.DiscoveryClient;


@SpringBootApplication
//@EnableCircuitBreaker
@EnableDiscoveryClient
//@EnableRedisHttpSession
@EnableWebSecurity
//@EnableWebFlux
@EnableCaching
@EnableAutoConfiguration
@EnableOAuth2Client
@EntityScan({"Phase1.Users","Gamoneynew.Gamoneywelcomenew"})
@ComponentScan({"Phase1.Users","Gamoneynew.Gamoneywelcomenew"})
@EnableJpaRepositories(basePackages= {"Phase1.Users","Gamoneynew.Gamoneywelcomenew"})
public class GamoneyWelcomeNewApplication {
    public GamoneyWelcomeNewApplication() {
    //	var v="";
    	System.out.println("i m initialized");
    }
    public static void premain(String h,Instrumentation u) {
    	System.out.println("Agent of S.H.E.I.L.D.S");
    }
	public static void main(String[] args) {
		    
			SpringApplication.run(GamoneyWelcomeNewApplication.class, args);
			System.out.println("GAMONEY WELCOMES YOU!");
			
	}


//	@Qualifier("redisUserTemplate")
	//@Autowired
	private RedisTemplate rt;
	//@Bean
//	public RSocket rsocket() {
//		return RSocketFactory.connect().dataMimeType(MimeTypeUtils.APPLICATION_JSON_VALUE).frameDecoder(PayloadDecoder.ZERO_COPY).transport(TcpClientTransport.create(7788)).start().block();
//	}
//	@Bean
//	public RSocketRequester socketRequester(RSocketStrategies strategies)   //FOR HTTP CONNECTIONS
//	{ 
//		InetSocketAddress address = new InetSocketAddress(7788);
//    
//    return RSocketRequester.builder()
//        .rsocketFactory(factory -> factory
//             .dataMimeType(MimeTypeUtils.ALL_VALUE)
//            .frameDecoder(PayloadDecoder.ZERO_COPY))
//           .rsocketStrategies(strategies)
//          .connect(TcpClientTransport.create(address))
//        .retry().block();
//	}
//	@Bean
//	public RSocketRequester socketRequester(RSocketStrategies strategies) throws URISyntaxException   //FOR WEB-SOCKET CONNECTION
//	{ 
//		InetSocketAddress address = new InetSocketAddress(7788);
//    
//    return RSocketRequester.builder()
//        .rsocketFactory(factory -> factory
//             .dataMimeType(MimeTypeUtils.ALL_VALUE)
//            .frameDecoder(PayloadDecoder.ZERO_COPY))
//           .rsocketStrategies(strategies)
//          .connectWebSocket(new URI("ws://localhost:8888/chatapp"))
//        .retry().block();
//	}
	//@Value("${server.ssl.key-store}")
	public String keystore;
	@Bean
	//@LoadBalanced TO ENABLE SSL OR TLS REQUESTS THROUH REST-TEMPLATE USING SSLConnectionSocketFactory  
	public RestTemplate get() throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException, FileNotFoundException, IOException {
//		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//		keyStore.load(new FileInputStream(new File("C:\\TrustStore\\keystore.p12")),
//		  "nikkibro0".toCharArray());
//    
//		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory( //for enabling https request handling it need to be configured
//		  new SSLContextBuilder()
//		    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
//		    .loadKeyMaterial(keyStore, "nikkibro0".toCharArray())
//		    .build(),
//		    NoopHostnameVerifier.INSTANCE);
//		HttpClient client = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
//    
//		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
//		  client);
		return new RestTemplate();
	}
	
//	
	@Value("${spring.view.prefix}")  
	private String  prefix;
    @Value("${spring.view.suffix}")
    private String suffix;
    @Value("${spring.view.view-names}")
    private String viewNames;
	@Bean
	public InternalResourceViewResolver jspViewResolver() throws FileNotFoundException, IOException {
		    final Properties p=new Properties();
		//    p.load(new FileInputStream("C:\\Users\\Nikki singh\\workspace-sts-3.9.8.RELEASE\\Gamoney-welcome\\src\\main\\resources\\application.properties"));
	        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix(p.getProperty(prefix));
	        viewResolver.setSuffix(p.getProperty(suffix));
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setViewNames(p.getProperty(viewNames));
	        return viewResolver;
	}
	//@Bean //FOR CROSS ORIGIN PLATFORMS
//	public WebMvcConfigurer configurer(){
//	  return new WebMvcConfigurer(){
//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	      registry.addMapping("/*")
//	          .allowedOrigins("*");
//	    }
//	  };
//	}
	@Bean
	public ServletWebServerFactory servletContainer() {   // FOR HTTPS REQUEST
	    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
	        @Override
	        protected void postProcessContext(Context context) 
	        { //A CALLBACK METHOD
	            SecurityConstraint securityConstraint = new SecurityConstraint();
	            securityConstraint.setUserConstraint("CONFIDENTIAL");
	            SecurityCollection collection = new SecurityCollection();
	            collection.addPattern("/*");
	            securityConstraint.addCollection(collection);
	            context.addConstraint(securityConstraint);
	        }
	    };
	    tomcat.addAdditionalTomcatConnectors(redirectConnector());
	    return tomcat;
	}
	 @Bean //this is not a actual filter its just a Configuration Bean for configuring filter in this webService For CORS options Request and actual request handling
	 public CorsFilter corsFilter() {
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     CorsConfiguration config = new CorsConfiguration();
	     config.setAllowCredentials(true); 
	     config.addAllowedOrigin("*"); //DO NOT SET "*" WHEN DEPLOYING WEBAPP IN INTERNET USE ACTUAL URL ORIGIN DOMAIN 
	     config.addAllowedHeader("*");      
	     config.addAllowedMethod("*");      
	     source.registerCorsConfiguration("/**", config);
	     CorsFilter cors=new CorsFilter(source);   
	     return cors;
	 }
	 @SuppressWarnings("deprecation")
	@Bean
	 public Connector redirectConnector() 
	 { //for redirecting HTTP request to HTTPS request
		  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		  connector.setScheme("http");
		  connector.setPort(8890);
		  connector.setSecure(false);
		  connector.setRedirectPort(8871);
		  connector.setAttribute("URIEncoding", "UTF-8");
		  return connector;
	 }
//	 @Bean(name="simpleMappingExceptionResolver")
//	 public SimpleMappingExceptionResolver exceptionHandler() {
//		 SimpleMappingExceptionResolver sr=new  SimpleMappingExceptionResolver();
//		 Properties mappings = new Properties();
//		    mappings.setProperty("PageNotFound", "databaseError");
//		    sr.setDefaultErrorView("thymeleaf/SignUp");
//		    sr.setExceptionAttribute("ex");
//		    sr.setExceptionMappings(mappings);
//		    sr.setWarnLogCategory("example.MvcLogger");  
//            return sr;
//	 }

}