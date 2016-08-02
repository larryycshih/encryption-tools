import java.io.UnsupportedEncodingException;

public class Vigenere extends Encrypt {

	public Vigenere(String Message, String Key) {
		// TODO Auto-generated constructor stub
		this.message = Message;
		this.key = Key;
		method_Name = "Vigenere Cipher";
	}

	public Vigenere(String Message) {
		// TODO Auto-generated constructor stub
		this.message = Message;
		this.key = null;
		method_Name = "Vigenere Cipher";
	}

	public void encrypt() {
		// TODO Auto-generated method stub
		if (key != null) {
			message = prepareMessage(message);
			key = prepareMessage(key);
			byte[] m = new byte[message.length()];
			int k = 0; // k counter

			for (int i = 0; i < message.length(); i++) {
				int tmp = (message.charAt(i) + key.charAt(k) - 130);
				tmp = (tmp % 26) + 65;
				m[i] = (byte) tmp;
				k++;
				if (k >= key.length())
					k = 0;
			}
			message = new String(m);
		}
	}

	public void decrypt() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub\
		if (key != null) {
			message = prepareMessage(message);
			key = prepareMessage(key);
			byte[] m = new byte[message.length()];
			int k = 0; // k counter

			for (int i = 0; i < message.length(); i++) {
				int tmp = (message.charAt(i) - key.charAt(k) + 130);
				tmp = (tmp % 26) + 65;
				m[i] = (byte) tmp;
				k++;
				if (k >= key.length())
					k = 0;
			}
			message = new String(m);
		}
	}	
}
