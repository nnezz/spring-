package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect2 { // 공통 기능 + Aspect 설정
	// 1. 공통 기능을 적용할 대상
	@Pointcut("execution(public * spring.calc..*(..))")
	private void factorialMethod() {}

	// 2. 공통 기능을 적용할 시점
	@Around("factorialMethod()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.nanoTime();

		Object result = joinPoint.proceed(); // 핵심 기능을 호출하는 메서드
		// 핵심 기능을 호출하기 위해서 필요한 정보 : 메서드 이름,반환타입,매개데이터,매개타입,순서

		long end = System.nanoTime();

		System.out.println("걸린시간 : " + (end - start));

		return result;
	}
}
