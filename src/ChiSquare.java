import java.util.Map;
import java.util.TreeMap;

public class ChiSquare {
	String msg;
	double chi;
	TreeMap<String, Double> E;
	
	public ChiSquare(String msg) {
		this.msg = msg;
		this.chi = calc();
		E = new TreeMap<String, Double>();
		E.put("A", 0.08167);
		E.put("B", 0.01492);
		E.put("C", 0.02782);
		E.put("D", 0.04253);
		E.put("E", 0.12702);
		E.put("F", 0.02228);
		E.put("G", 0.02015);
		E.put("H", 0.06094);
		E.put("I", 0.06966);
		E.put("J", 0.00153);
		E.put("K", 0.00772);
		E.put("L", 0.04025);
		E.put("M", 0.02406);
		E.put("N", 0.06749);
		E.put("O", 0.07507);
		E.put("P", 0.01929);
		E.put("Q", 0.00095);
		E.put("R", 0.05987);
		E.put("S", 0.06327);
		E.put("T", 0.09056);
		E.put("U", 0.02758);
		E.put("V", 0.00978);
		E.put("W", 0.02360);
		E.put("X", 0.00150);
		E.put("Y", 0.01974);
		E.put("Z", 0.00074);
	}
	
	public double calc(){
		// formula
		// the sum of ((C - E)^2 / E)
		
		// we need freq analysis of msg and 
		// expected letter frequency
		
		double tmp = 0.0;
		FreqDistribution f = new FreqDistribution(msg);
		
		for (Map.Entry<Character, Integer> entry : f.getFreqDistrib().entrySet()) {
			double c = entry.getValue(); 
			double e = E.get(entry.getKey()) * f.getCount() ;
			
			tmp += ( (c - e)*(c - e) )/e; 
		
		}
		return tmp;
	}

}
