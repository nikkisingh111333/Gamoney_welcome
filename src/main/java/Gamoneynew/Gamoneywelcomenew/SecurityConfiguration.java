package Gamoneynew.Gamoneywelcomenew;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;



@Order(value=0)
@Configuration
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { //ALL ABOUT SECURITY USING SPRING SECURITY
	
   @Autowired
   private CorsFilter cors;
   @Override
   protected void configure(HttpSecurity http) throws Exception { //request configs
	   http.csrf().ignoringAntMatchers("/actuator/**","/ImageTest","/user");
	   
	   http.cors().and().authorizeRequests()
	   .antMatchers("/HowMuchStarsLeft","/user","/Wallet","/SIGNUP")
	   .hasRole("USER")
	   .and()
	   .authorizeRequests()
	   .antMatchers(HttpMethod.OPTIONS, "/HowMuchStarsLeft")
	   .permitAll() //FOR ENABLE OPTION CORS REQUEST BY BROWSER TO BE PERMITTED IF SENT
	   .and()
	   .authorizeRequests().antMatchers("/Admin_portal","/actuator/**").hasRole("ADMIN")
	   .and()
	   .authorizeRequests().antMatchers(HttpMethod.POST,"/PhoneNumberUpdate","/login","/connect/facebook","/ImageTest").permitAll()
	   .and()
	   .authorizeRequests().antMatchers("/send","/cache/*","/Data","/user","/dream","/login/oauth2/code/google","/reinvoke","/liveVideo","/logmein","/loginMe","/welcome","/SIGNUP","/save","/firstpage","/ESearch").permitAll()
	   .and()
	   .authorizeRequests().antMatchers("/**")
	   .authenticated()
	   .and()
	   .formLogin()//if a user is not authenticated this will send a login page custom or default to the client
	    .loginPage("/login")
	    .defaultSuccessUrl("/loginAccess",true)
	    .permitAll()
	   .and()
	   .logout()
	     .invalidateHttpSession(true)
	     .deleteCookies("JSESSIONID")
	   .and()
	     .rememberMe()
	     .userDetailsService(userDetailsService)
	     .tokenValiditySeconds(2000000)
	     .key("YaadRakhnaMujhe")
	    .and()
	     .exceptionHandling()
	     .accessDeniedPage("/forbidden")
	    .and()
	     .oauth2Login()
	     .defaultSuccessUrl("/loginAccess")
	     .loginPage("/loginMe");  //WE WILL LEARN ABOUT OAUTH-2 LOGIN MORE
//	   http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
//       requests.anyRequest().hasRole("ADMIN"));

//	   .and()
//	   .csrf().disable();
	   
   }
  // @Autowired
   protected PasswordEncoder passwordEncoder;
//   @Autowired
//   private ConnectionFactoryLocator connectionFactoryLocator;
//   @Autowired
//   private DataSource datasourceForfacebook;
//   
//   @Autowired
//   private UsersConnectionRepository usersConnectionRepository;

//   @Autowired
//   private FacebookConnectionSignup facebookConnectionSignup;

//   @Bean
//   public FilterRegistrationBean corsFilter() {
//       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//       CorsConfiguration config = new CorsConfiguration();
//       config.setAllowCredentials(true);
//       config.addAllowedOrigin("*");
//       config.setAllowedMethods(Arrays.asList("POST", "OPTIONS", "GET", "DELETE", "PUT"));
//       config.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
//       source.registerCorsConfiguration("/**", config);
//       FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//       bean.setOrder(Ordered.HIGHEST_PRECEDENCE);// THIS FILTER WILL INVOKE AT TOP WHENEVER ANY BROWSER WILL ATTEMP A CORS OPTIONS REQUEST TO THE SERVER I.E PREFLIGHT REQUEST
//       return bean;
//   }
//   @Bean  //CREATE A LOGIN CONTROLLER FOR FACEBOOK CONTROLLER
//   public ProviderSignInController providerSignInController() {
////       ((InMemoryUsersConnectionRepository) usersConnectionRepository)
////         .setConnectionSignUp(facebookConnectionSignup);
////        
//       return new ProviderSignInController(
//         connectionFactoryLocator, 
//         usersConnectionRepository, 
//         new FacebookLogin());
//   }
   @Autowired
   private UserServices userDetailsService;
   @Bean
   protected DaoAuthenticationProvider authDbmsSetUp() {
	   DaoAuthenticationProvider daoAuth=new DaoAuthenticationProvider();
	   daoAuth.setUserDetailsService(userDetailsService);
	   daoAuth.setPasswordEncoder(this.passEncode());  //Encode password in hash and compare it with password provided 
	   return daoAuth;
   }
   @Bean
   public BCryptPasswordEncoder passEncode() {
	   return new BCryptPasswordEncoder();
   }
//   @Bean
//   public ConnectionFactoryLocator connectionFactoryLocator() {
//       ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
//   //    System.out.println("Properties:"+ env.getProperty("spring.redis.host"));
//       registry.addConnectionFactory(new FacebookConnectionFactory(
//          "4008569932502035",
//           "e96a7c94680ed7720e9d8f49e9af02be"));
//       
//       
//       return registry;
//   }
   @Autowired
   private Environment env;
  // @Autowired
   private TextEncryptor textEncryptor;	
//   @Bean
//   @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
//   public ConnectionRepository connectionRepository() {
//       Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
//       if (authentication == null) {
//           throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
//       }
//       return usersConnectionRepository().createConnectionRepository(authentication.getName());
//   }
//   @Bean
//   public UsersConnectionRepository usersConnectionRepository() { //SPRING SOCIAL JDBCUSERCONNECTION
//       return new JdbcUsersConnectionRepository(datasourceForfacebook, connectionFactoryLocator(), 
//           textEncryptor);
//   }
//   @Bean
//   public TextEncryptor textEncryptor() {
//       return Encryptors.noOpText();
//   }
//   @Bean
//   public ConnectController connectController() {
//       return new ConnectController(connectionFactoryLocator(), 
//           connectionRepository());
//   }
	
}
