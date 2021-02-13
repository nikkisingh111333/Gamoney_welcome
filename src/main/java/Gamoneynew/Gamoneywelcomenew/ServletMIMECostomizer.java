package Gamoneynew.Gamoneywelcomenew;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServletMIMECostomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
 //   @Override
    public void customize(TomcatServletWebServerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("webm", "video/webm");
        factory.setMimeMappings(mappings);  //THIS WILL ADD NEW MIME TYPE SUPPERT FOR SERVLET COINTAINER AS RESPONSE
    }
}