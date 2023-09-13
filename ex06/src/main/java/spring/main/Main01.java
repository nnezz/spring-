package spring.main;

import spring.calc.ImpCalculator;
import spring.calc.RecCalculator;

public class Main01 {

	public static void main(String[] args) {
		ImpCalculator imp = new ImpCalculator();
		long fiveFacImp = imp.factorial(5);
		
		RecCalculator rec = new RecCalculator();
		long fiveFacRec = rec.factorial(5);
		
		System.out.println("fiveFacImp : "+fiveFacImp);
		System.out.println("fiveFacRec : "+fiveFacRec);
		
		
	}

}
