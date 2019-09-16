package aimage;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class aimageDTO {

	
	  public static byte[] decodeBase64(String input)
	    {
		  Decoder decoder = Base64.getDecoder();
	        
	        // Decoder#decode(bytes[] src) 
	        byte[] decodedBytes1 = decoder.decode(input);
	        // Decoder#decode(String src)
	        
	        // ���ڵ��� ���ڿ��� ǥ��
	        String decodedString = null;
			try {
				decodedString = new String(decodedBytes1, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(decodedString);
	        return decodedBytes1;
	    }
	  
	  
}
