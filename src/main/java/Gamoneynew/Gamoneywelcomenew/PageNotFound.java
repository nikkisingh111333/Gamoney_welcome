package Gamoneynew.Gamoneywelcomenew;

import org.springframework.stereotype.Component;


public class PageNotFound extends RuntimeException{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    public PageNotFound(String message) {
    	super(message+"_PageNotFound 404 .may be you are lost!");
    }
}
