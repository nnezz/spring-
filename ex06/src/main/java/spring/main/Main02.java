package spring.main;

import spring.calc.ExeTimeCalculator;
import spring.calc.ImpCalculator;
import spring.calc.RecCalculator;

public class Main02 {

	public static void main(String[] args) {
		//프록시 객체를 통해서 두가지 방법의 팩토리얼 구하기
		
		ExeTimeCalculator impeCalc = new ExeTimeCalculator(new ImpCalculator());
		long fiveFacImpe = impeCalc.factorial(5);
		
		ExeTimeCalculator recCalc = new ExeTimeCalculator(new RecCalculator());
		long fiveFacRec = recCalc.factorial(5);
		
		System.out.println("fiveFacImp : "+fiveFacImpe);
		System.out.println("fiveFacRec : "+fiveFacRec);
		
	}

}
