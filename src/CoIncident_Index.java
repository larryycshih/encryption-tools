import java.util.Map;

public class CoIncident_Index {
	private String msg;
	private double CI;
	private int c;
	public CoIncident_Index(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
		this.c = 26;
		processing();
	
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
	public double getCI(){
		return CI;
	}

}
