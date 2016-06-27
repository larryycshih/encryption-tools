import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Vigenere extends Encrypt{
	
	private String Key;
	
	public Vigenere(String Message, String Key) {
		// TODO Auto-generated constructor stub
		this.message = Message;
		this.Key = Key;
		method_Name = "Vigenere Cipher";
	}

	public void encrypt()  {
		// TODO Auto-generated method stub
		message = prepareMessage(message);
		Key = prepareMessage(Key);
		byte[] m = new byte[message.length()];
		int k = 0; // k counter
		
		for (int i = 0; i < message.length(); i ++){
			int tmp =   (message.charAt(i) + Key.charAt(k) -130);
			tmp = (tmp % 26)+65;
			m[i]=(byte) tmp;
			k++;
			if (k >= Key.length()) k = 0;	
		}
		message = new String (m);
	}

	public void decrypt() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		message = prepareMessage(message);
		Key = prepareMessage(Key);
		byte[] m = new byte[message.length()];
		int k = 0; // k counter
		
		for (int i = 0; i < message.length(); i ++){
			int tmp =   (message.charAt(i) - Key.charAt(k) +130);
			tmp = (tmp % 26)+65;
			m[i]=(byte) tmp;
			k++;
			if (k >= Key.length()) k = 0;	
		}
		message = new String (m);
	}

}
