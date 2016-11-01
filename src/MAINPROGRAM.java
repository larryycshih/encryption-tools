import java.util.Scanner;
import java.io.*;
import java.nio.file.ReadOnlyFileSystemException;

public class MAINPROGRAM {
	static Scanner kb = new Scanner(System.in);

	private static File inputFile;
	private static Encrypt encrypt;
	private static String cipherText = "";

	public static void main(String[] args) {

		// File cipher = new File("cipher_challenge1.txt");
		// Scanner s;
		// String cipherText = "";
		// try {
		// s = new Scanner(cipher);
		// while (s.hasNext()) {
		// cipherText += s.next();
		//
		// }
		// s.close();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// encrypt = new Column("The Quick brown fox jump over the lazy fence",
		// 7);
		// encrypt = new Vigenere(cipherText);

		// System.out.println(new CoIncident_Index(cipherText).getCI());

		// encrypt.encrypt();
		// System.out.println(encrypt.printMessage());
		// encrypt.decrypt();
		// System.out.println(encrypt.printMessage());

		// Cracker c = new Cracker(encrypt,new File("wordlist/sowpods.txt"),new
		// File("wordlist/top1000Decapped.txt"),new File("output/"));
		// try {
		// c.DictionaryAttack();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.println( new CoIncident_Index(cipherText).toString() );

		try {
			menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void menu() throws IOException {
		/*
		 * Main Menu workflow 1. Set Input as FILENAME or as STRING 2. Set
		 * Encryption Type. 3. Set Dictionary File as FILENAME
		 * 
		 * ....
		 * 
		 * 7. Run BruteForce Crack 8. Run Dictionary Crack
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		System.out.println("Welcome to sycin's cracking software.");
		System.out.println("This Software will attempt to crack encryptions");
		System.out.println("-----------------------------------------------");
		System.out.println("1) Set Input");
		System.out.println("2) Set Encryption Type");
		System.out.println("3) Set Dictionary File");
		System.out.println("7) Run BruteForce Attack");
		System.out.println("8) Run Dictionary Attack");
		System.out.print("$> ");

		input = br.readLine();

		// option 1 - set Input
		if (input.equals("1")) {
			System.out.println("Source of input: ");
			System.out.println("1) Set as FileName");
			System.out.println("2) Set as String");
			input = br.readLine();
			if (input.equals("1")) {
				System.out.println("Enter File Name");
				File f = new File(br.readLine());
				if (f.exists()) cipherText = readFromFile(f);	else onError();
			} else if (input.equals("2")) {
				System.out.println("Enter Encryption String");
				cipherText = br.readLine();
			} else 	onError();			
		}
		// option 2 - set encryption type
		else if (input.equals("2")) {
			System.out.println("Pick Encryption type");
			System.out.println("1) Caesar");
			System.out.println("2) Column");
			System.out.println("3) Vigenere");
			
			if (input.equals("1")) {

			} else if (input.equals("2")) {
			 
			} else if (input.equals("3")) {

			}	
			else onError();
			
		}
		// option 3
		else if (input.equals("3")) {

		}
		// option 7
		else if (input.equals("7")) {

		}
		// option 8
		else if (input.equals("8")) {

		} else {
			onError();
		}
		br.close();
		menu();
	}

	public static String readFromFile(File f) {
		String str = "";
		try {
			Scanner s = new Scanner(f);
			while (s.hasNext()) {
				cipherText += s.next();
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return str;
	}

	private static void onError() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("INVALID INPUT... ERROR");
		System.out.println("----HIT ENTER TO CONTINUE ----");
		try {
			br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
