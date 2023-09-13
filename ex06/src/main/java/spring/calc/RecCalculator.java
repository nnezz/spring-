package spring.calc;

public class RecCalculator implements Calculator {
	// 팩토리얼 구하기 위한 클래스 : 재귀함수로 팩토리얼 구하기

	@Override
	public long factorial(long num) {

	//	long start = System.currentTimeMillis(); // 밀리초 단위로 현재 시간을 측정

	//	try {
			if (num == 0) {
				return 1;
			} else {
				return num * factorial(num - 1);  // 5*4*3*2*1*1
			}
	//	} finally {
	//		long end = System.currentTimeMillis(); // 밀리초 단위로 현재 시간을 측정

	//		System.out.printf("RecCalculator.factorial(%d)의 실행시간 : %d ", num, (end - start));
		
			
		}

	}


