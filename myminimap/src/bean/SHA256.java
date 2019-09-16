package bean;
import java.security.*;

public class SHA256 {
   public static String Encrypt(String str)
   {
      StringBuffer strBuffer = new StringBuffer();
      try {
         MessageDigest sha = MessageDigest.getInstance("SHA-256");
         sha.update(str.getBytes());
         byte[] digest = sha.digest();
         for (int i=0; i < digest.length; i++)
         {
            byte tempString = digest[i];
            String encryptString = Integer.toString((tempString & 0xff) + 0x100, 16).substring(1);
            strBuffer.append(encryptString);
         } 
      }catch(NoSuchAlgorithmException e) 
         {
            e.printStackTrace();
         }
      return strBuffer.toString();
   }

}