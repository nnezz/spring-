package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.calc.Calculator;
import spring.config.JavaConfig;

public class Main05 {

	public static void main(String[] args) {
	//java를 이용한 Aspect를 설정하는방법 @Aspect 객체를 사용해야한다.
		
		AnnotationConfigApplicationContext ctx = 
		new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		long result = impeCalc.factorial(10);
		
		System.out.println("계산결과 : "+result);
	}

}
