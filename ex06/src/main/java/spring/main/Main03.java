package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main03 {

	public static void main(String[] args) {
	//XML 설정 기반 POJO 공통 기능을 이용한 방법
		
		GenericXmlApplicationContext ctx = 
		new GenericXmlApplicationContext("classpath:appCtx01.xml");
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		//ImpCalculator impeCalc = ctx.getBean("impeCalc",ImpCalculator.class);
		
		long result = impeCalc.factorial(10);
		
		System.out.println("계산결과 : "+result);
	}

}
