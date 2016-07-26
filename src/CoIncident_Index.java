import java.util.Map;

public class CoIncident_Index {
	private String msg;
	private double CI;
	private int c;
	private double[] period;
	private int p_size = 20;

	public CoIncident_Index(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
		this.c = 26;
		CI = calcCI(msg);
		period = new double[p_size];
		findPeriod();
	}

	private double calcCI(String m) {
		FreqDistribution f = new FreqDistribution(m);
		double N = m.length();
		double tmp = 0.0;
		// iterate over all key pairs and add them all into tmp

		for (Map.Entry<Character, Integer> entry : f.getFreqDistrib().entrySet()) {
			double v = entry.getValue();
			//these equation all seem to be wrong seriously wtf
			
			// tmp += ((v / N) * ((v-1)/(N-1)));
			// tmp += (v * (v - 1)) / (N * (N - 1)) / c;
			tmp = tmp+ v*(v-1);
		}
		tmp = tmp / (N*(N-1));
		return tmp;
	}

	private void findPeriod() {
		// sort msg into arrays with with each character at intervals of x
		// for 1 to 15 calc CI averages for each intervals

		for (int i = 0; i < period.length; i++) {
			double average = 0;
			String[] str = sortMsgByLength(i + 1);
			for (String s : str) {
				average += calcCI(s);
			}
			average = average / str.length;
			period[i] = average;
		}

	}

	private String[] sortMsgByLength(int x) {
		String[] str = new String[x];
		// it seems i need to init the array
		for (int i = 0; i < str.length; i++) {
			str[i] = "";
		}
		// split the message into multiple arrays
		int j = 0;
		for (int i = 0; i < msg.length(); i++) {
			if (j >= x)
				j = 0;
			str[j] += msg.charAt(i);
			j++;
		}
		return str;
	}

	public double getCI() {
		return CI;
	}

	public double[] getPeriod() {
		return period;
	}

	public String toString() {
		String str = "CI, " + CI + "\nPeriods\n";
		for (int i = 0; i < period.length; i++) {
			str += i + 1 + "," + period[i] + "\n";
		}
		return str;
	}

}
