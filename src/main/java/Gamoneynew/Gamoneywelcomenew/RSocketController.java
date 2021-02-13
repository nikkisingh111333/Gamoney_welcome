package Gamoneynew.Gamoneywelcomenew;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
class MessageModel {

    private String message;
    private String fromLogin;

    public MessageModel(String message, String fromLogin) {
	
		this.message = message;
		this.fromLogin = fromLogin;
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromLogin() {
        return fromLogin;
    }

    public void setFromLogin(String fromLogin) {
        this.fromLogin = fromLogin;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "message='"
 + message + '\'' +
                ", fromLogin='" + fromLogin + '\'' +
                '}';
    }
}

  
@RestController
public class RSocketController {
   //@Autowired
   private RSocketRequester r;
  @GetMapping("/send")
  public Publisher<MessageModel> send(){
	  return r.route("chat").data(new MessageModel("hii broda","nikki")).retrieveMono(MessageModel.class).log();
  }
}
