import java.util.Scanner;
import java.io.*;

public class MAINPROGRAM {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		File cipher = new File("cipher_challenge1.txt");
		Scanner s;
		String cipherText = null;
		Encrypt encrypt;
		try {
			s = new Scanner(cipher);
			while (s.hasNext()) {
				cipherText += s.next();

			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//encrypt = new Column("The Quick brown fox jump over the lazy fence", 7);
		encrypt = new Vigenere(cipherText, "lemon");

		encrypt.encrypt();
		System.out.println(encrypt.printMessage());
		encrypt.decrypt();
		System.out.println(encrypt.printMessage());
	}

}
