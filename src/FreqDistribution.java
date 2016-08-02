
import java.util.TreeMap;

public class FreqDistribution {
	private char[] msg;
	private TreeMap<Character, Integer> freq = new TreeMap<Character, Integer>();

	public FreqDistribution(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg.toUpperCase().replace(" ", "").toCharArray();
		process();
	}

	private void process() {
		for (char c : msg) {
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) + 1);
			} else {
				freq.put(c, 1);
			}
		}
	}

	public TreeMap<Character, Integer> getFreqDistrib() {
		return freq;
	}
	
	public int getCount(){
		return msg.length;	
	}
}
