import java.util.Map;

public class CoIncident_Index {
	private String msg;
	private double CI;
	private int c;
	private double[] period;
	private int p_size = 15;
	public CoIncident_Index(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
		this.c = 26;
		processing();
		period = new double[p_size];
		findPeriod();
	}
	
	private void processing(){
		FreqDistribution f = new FreqDistribution(msg);
		double N = f.getFreqDistrib().size();
		double tmp = 0.0;
		//iterate over all key pairs and add them all into tmp

		for (Map.Entry<Character,Integer> entry : f.getFreqDistrib().entrySet()){
			double v = entry.getValue();
			
			//tmp += ((v / N) * ((v-1)/(N-1)));
			tmp += (v * (v-1)) / (N*(N-1))/c;
		}
		CI = tmp;
	}
	
	private double calcCI(String m){
		FreqDistribution f = new FreqDistribution(m);
		double N = f.getFreqDistrib().size();
		double tmp = 0.0;
		//iterate over all key pairs and add them all into tmp

		for (Map.Entry<Character,Integer> entry : f.getFreqDistrib().entrySet()){
			double v = entry.getValue();
			
			//tmp += ((v / N) * ((v-1)/(N-1)));
			tmp += (v * (v-1)) / (N*(N-1))/c;
		}
		return tmp;
	}
	
	private void findPeriod(){
		//sort msg into arrays with with each character at intervals of x
		int i = 0;
		for (String s : sortMsgByLength(3)){
			period[i] = calcCI(s);
			i++;
		}
		
	}
	
	private String[] sortMsgByLength(int x){
		String [] str = new String[x];
		str[0] = "";
		str[1] = "";
		str[2] = "";
		int j = 0;
		for (int i = 0; i < msg.length(); i++){
			if (j >= x) j =0;
			str[j] += msg.charAt(i);
			j++;
		}
		return str;
	}
	
	
	public double getCI(){return CI;}
	
	public double[] getPeriod(){return period;}
	
	public String toString(){
		String str = "CI: "+CI + "\nPeriods\n";
		for (int i = 0 ; i < 15 ;i++){
			str += i+1+":"+period[i]+"\n"; 
		}
		return str;
	}
	

}
