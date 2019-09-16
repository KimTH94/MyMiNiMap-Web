package bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class encodeURIComponent {
	
	public static String encodeURIComponent(String URI){
	    String result = null;
	    try {
	      result = URLEncoder.encode(URI, "UTF-8")
	                         .replaceAll("\\+", "%20")
	                         .replaceAll("\\%21", "!")
	                         .replaceAll("\\%27", "'")
	                         .replaceAll("\\%28", "(")
	                         .replaceAll("\\%29", ")")
	                         .replaceAll("\\%7E", "~");
	    }
	 
	    catch (UnsupportedEncodingException e)
	    {
	      result = URI;
	    }
	 
	    return result;
	  }
}
