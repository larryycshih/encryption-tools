import java.util.Arrays;


public class Column extends Encrypt {
	static private String method_Name = "Column Encryption";
	int key;

	public Column() {
		// TODO Auto-generated constructor stub
	}

	public Column(String message) {
		this.key = 3; // have the encryption key set to 3 by default
		this.message = prepareMessage(message);
	}

	public Column(String message, int key) {
		this.key = key;
		this.message = prepareMessage(message);
	}
	
	public void encrypt() {
		String[] col = formatMessage(getMessage(), key).split(" ");
		String tmpstr = "";
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < col.length; j++) {
				try {
					tmpstr += col[j].charAt(i);
				} catch (Exception e) {
				}
			}
		}
		setMessage(tmpstr);
	}

	public void decrypt() {
		String tmpstr = prepareMessage(getMessage());

		String[] row = new String[key];
		Arrays.fill(row, "");
		int n = tmpstr.length();
		int r = n%key;
		int colLength=(n-r)/key;
		int charStartIndex=0;
		
		for (int i = 0; i < key; i++){
			if(i < r){
				row[i] = tmpstr.substring(charStartIndex, charStartIndex+colLength+1);
				charStartIndex+=colLength+1;
			}else{
				row[i] = tmpstr.substring(charStartIndex,charStartIndex+colLength);
				charStartIndex+=colLength;
			}
		}
		
		tmpstr = "";
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < row.length; j++) {
				try {
					tmpstr += row[j].charAt(i);
				} catch (Exception e) {
				}
			}
		}
		setMessage(tmpstr);
		//setMessage(tmpstr);
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
