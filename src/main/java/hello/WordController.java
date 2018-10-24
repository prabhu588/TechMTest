package hello;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController { 
	@Autowired
	private Greetings greeting;
    // TODO Implement the /words/{word} endpoint
	 @RequestMapping(path="/words/{word}" )
	    public Greetings greeting(@PathVariable("word") String word) {
		 System.out.println("word"+word);
		 greeting.setPalindrome(checkPalindrome(word));
		 greeting.setAnagramOfPalindrome(canFormPalindrome(word));
		 greeting.setWord(word);
		return greeting;
	    }
	 public boolean checkPalindrome(String word){
		 String reverse = "";
		 int length = word.length();
	     
	      for (int i = length - 1; i >= 0; i--)
	         reverse = reverse + word.charAt(i);
	         
	      if (word.equals(reverse))
	         return true;
	      else
	         return false;
	         
	   }
	public boolean canFormPalindrome(String str) 
	    { 
		 int NO_OF_CHARS = 256; 
	        // Create a count array and initialize 
	        // all values as 0 
	        int[] count = new int[NO_OF_CHARS]; 
	  
	        // For each character in input strings, 
	        // increment count in the corresponding 
	        // count array 
	        for (int i = 0; i < str.length(); i++) 
	            count[str.charAt(i)]++; 
	  
	        // Count odd occurring characters 
	        int odd = 0; 
	        for (int i = 0; i < NO_OF_CHARS; i++) { 
	            if ((count[i] & 1) != 0) 
	                odd++; 
	  
	            if (odd > 1) 
	                return false; 
	        } 
	  
	        // Return true if odd count is 0 or 1, 
	        return true; 
	    } 
		
		 
	 
}
