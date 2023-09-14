package spring.aspect;


import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	
	private Map<Long,Object> cache = new HashMap<>(); 
	
	public Object xxx(ProceedingJoinPoint jp) throws Throwable{
		long num = (Long)jp.getArgs()[0];
		
		if(cache.containsKey(num)) {  //저장된 숫자가 있다면
			System.out.println("캐시에 결과 읽기 : "+num);
			return cache.get(num);
			
		}
		
		Object result = jp.proceed(); //팩토리얼 계산
		
		cache.put(num, result); // 캐시에 결과저장
		System.out.println("캐시에 결과 저장 : "+num);
		System.out.println("캐시에 결과 저장 : "+num);
		return result;
		
	}
}
