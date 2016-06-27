
public class Caesar extends Encrypt {
	static private String method_Name = "Caesar Encryption";
	int key;
	static int MIN_ASCII_VALUE = 65;
	static int MAX_ASCII_VALUE = 90;

	public Caesar() {
		// TODO Auto-generated constructor stub

	}

	public Caesar(String message) {

		this.message = message;
		this.key = 3; // have the encryption key set to 3 by default
		this.message = prepareMessage(message);
	}

	public Caesar(String message, int key) {

		this.message = message;
		this.key = key;
		this.message = prepareMessage(message);
	}

	public void encrypt() {

		String tmp = getMessage();
		String result = "";
		int charIndex;
		for (int i = 0; i < tmp.length(); i++) {

			charIndex = (int) tmp.charAt(i);
			if (charIndex != 32) {
				charIndex += key;
				if (charIndex > MAX_ASCII_VALUE)
					charIndex = MIN_ASCII_VALUE + (charIndex - MAX_ASCII_VALUE);
			}
			result += (char) charIndex;
		}
		setMessage(result);
	}

	public void decrypt() {

		String tmp = getMessage();
		String result = "";
		int charIndex;
		for (int i = 0; i < tmp.length(); i++) {

			charIndex = (int) tmp.charAt(i);
			if (charIndex != 32) {
				charIndex -= key;
				if (charIndex < MIN_ASCII_VALUE)
					charIndex = MAX_ASCII_VALUE - (MIN_ASCII_VALUE - charIndex);
			}
			result += (char) charIndex;
		}
		setMessage(result);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getMethod_Name() {
		return method_Name;
	}

	public String printMessage() {
		return formatMessage(getMessage());
	}
}
