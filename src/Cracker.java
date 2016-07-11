
/**
 * this program will take a encryption method and attempt to crack it using
 * either brute force or wordlist.
 * 
 * the result is compared with a verification wordlist. if it has a number of
 * these common words then it is stored as a file in folder
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cracker {

	Encrypt e; // the encryption method to perform
	File dict; // the dictionary file to use
	File check; // the wordlist used to check results
	File outputDir; // the output directory

	private String _MODE;

	/**
	 * 
	 * @param e
	 *            - is the encryption algorithm to process
	 * @param dict
	 *            -
	 * @param check
	 * @param outputDir
	 */
	public Cracker(Encrypt e, File dict, File check, File outputDir) {
		super();
		this.e = e;
		this.dict = dict;
		this.check = check;
		this.outputDir = outputDir;
	}

	public Cracker(Encrypt e, File dict, File outputDir, String mode) {
		super();
		this.e = e;
		this.dict = dict;
		this.outputDir = outputDir;
		this._MODE = mode;
	}

	public void BruteForce() {

	}

	public void DictionaryAttack() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dict));
		ArrayList<Result> list = new ArrayList<>();
		int count = 0;

		for (String line; (line = br.readLine()) != null;) {
			e.setKey(line);
			e.decrypt();
			list.add(new Result(e.getMessage(),e.getKey()));
		}

		// checking phrase
		br = new BufferedReader(new FileReader(check));
		for (String line; (line = br.readLine()) != null;) {
			for (Result s : list) {

				// for each item in checking list
				if (s.getMessage().trim().contains(line.toUpperCase())) {
					s.update();
				}
			}

		}
		for (Result s : list) {
			
			if (s.getCI() >= 0.06) {
				System.out.println(count + "," + s.getCount() + "," + s.getCI() +"," + s.getMessage());
				count++;
			}
		}
	}

	private class Result {
		String key;
		String msg;
		int count;
		double CI;
		public Result(String str, String key) {
			this.msg = str;
			this.count = 0;
			CI = new CoIncident_Index(msg).getCI();
			this.key = key;
		}
		public void update() {count++;}
		public String getMessage() {return key + ":" + msg;}
		public int getCount() {return count;}
		public double getCI(){return CI;}
	}

}
