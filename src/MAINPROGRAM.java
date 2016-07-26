import java.util.Scanner;
import java.io.*;

public class MAINPROGRAM {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		File cipher = new File("cipher_challenge1.txt");
		Scanner s;
		String cipherText = "";
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
		encrypt = new Vigenere(cipherText);

		
		//System.out.println(new CoIncident_Index(cipherText).getCI());
		
//		encrypt.encrypt();
//		System.out.println(encrypt.printMessage());
//		encrypt.decrypt();
//		System.out.println(encrypt.printMessage());
	
//		Cracker c = new Cracker(encrypt,new File("wordlist/sowpods.txt"),new File("wordlist/top1000Decapped.txt"),new File("output/"));
//		try {
//			c.DictionaryAttack();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println( new CoIncident_Index(cipherText).toString() );
	}

}
