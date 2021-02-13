package Phase1.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import Gamoney.PageNotFound;
class ExceptionResponse{
	String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String h) {
		this.message=h;
	}
}
@RestController
//CUSTOM EXCEPTION HANDLERS

public class ExceptionHandlerController implements ErrorController{


	@RequestMapping("/error")
	public ModelAndView handleResourceNotFound(HttpStatus status,
			final HttpServletRequest request) {
        System.out.println("WHAT THE FUCK HAPPENED:"+request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)+"---"+request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		Integer error=(Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);//RequestDispactcher for status code
        if(error==404) {
		return new ModelAndView("thymeleaf/NotFound");  ///We will make error animated templates dont woory about it
        }
        else if(error==500) {
        	System.out.println(RequestDispatcher.ERROR_MESSAGE);
        	System.out.println(RequestDispatcher.ERROR_EXCEPTION);
        	return new ModelAndView("thymeleaf/NotFound");
        }

        return new ModelAndView("thymeleaf/AllErrorPage");
	}

	//@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	@RequestMapping("/forbidden")
	public ModelAndView forbid(HttpServletRequest req) {
		System.out.println("FORBIDDEN:"+RequestDispatcher.ERROR_STATUS_CODE);
		return new ModelAndView("thymeleaf/Forbidden");
		
	}
}
