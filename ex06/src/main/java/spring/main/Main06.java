package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main06 {

	public static void main(String[] args) {
		//XML 설정 기반 POJO 공통 기능을 이용한 방법
			
			GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:appCtx03.xml");
			
			Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
			//ImpCalculator impeCalc = ctx.getBean("impeCalc",ImpCalculator.class);
			
			long result1 = impeCalc.factorial(10); //캐시가 없는 경우
			long result2 = impeCalc.factorial(10); //캐시가 있는 경우
			
			
		}

	}
