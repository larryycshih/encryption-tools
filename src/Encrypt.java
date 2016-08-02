public abstract class Encrypt {
	protected String method_Name;
	String message;
	String key;

	public Encrypt() {
		// TODO Auto-generated constructor stub
	}

	abstract public void encrypt();

	abstract public void decrypt();

	/**
	 * Format the message into blocks of 5 characters
	 * 
	 * @param str
	 * @return string in block of 5 characters
	 */
	protected String formatMessage(String str) {
		String tmpstr = "";
		for (int i = 0; i < str.length(); i++) {
			tmpstr += str.charAt(i);
			if ((i + 1) % 5 == 0 && i != 0)
				tmpstr += " ";
		}
		return tmpstr;
	}

	/**
	 * Format the message into blocks of x characters
	 * 
	 * @param str
	 * @return string in block of x characters
	 */
	protected String formatMessage(String str, int x) {
		String tmpstr = "";
		for (int i = 0; i < str.length(); i++) {
			tmpstr += str.charAt(i);
			if ((i + 1) % x == 0 && i != 0)
				tmpstr += " ";
		}
		return tmpstr;
	}

	protected String prepareMessage(String str) {
		// TODO Auto-generated method stub
		str = str.toUpperCase();
		return str.replace(" ", "");
	}

	public String printMessage() {
		return prepareMessage(getMessage());
	}

	protected String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getKey(){return key;}

	public void setKey(String key) {
		this.key = key;
	}

}
