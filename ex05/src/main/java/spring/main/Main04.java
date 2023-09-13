package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client;
import spring.config.JavaConfig;

public class Main04 {

	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		Client client1_1 = ctx.getBean("client",Client.class); //싱글턴
		Client client1_2 = ctx.getBean("client",Client.class);

		Client client3_1 = ctx.getBean("client3",Client.class); // 프로토타입
		Client client3_2 = ctx.getBean("client3",Client.class);
		
		
		System.out.println("=============================================================");
		System.out.println("client1_1 == client1_2 => "+(client1_1 == client1_2));
		System.out.println("client3_1 == client3_2 => "+(client3_1 == client3_2));
	}
}
