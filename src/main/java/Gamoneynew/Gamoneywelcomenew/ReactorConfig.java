package Gamoneynew.Gamoneywelcomenew;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

@Configuration
public class ReactorConfig {
  public ReactorClientHttpConnector getConnector() {
	  ReactorClientHttpConnector x= new ReactorClientHttpConnector();  
	return null;
  }
}
