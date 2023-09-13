package spring.calc;

public class ExeTimeCalculator implements Calculator{

	private Calculator calc; //실제 계산 하기 위한 클래스(Imp,Rec)
	
	public ExeTimeCalculator(Calculator calc) {		
		this.calc = calc;
	}

	@Override
	public long factorial(long num) {
		
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		long result = calc.factorial(num);
		
		//long end = System.currentTimeMillis();
		long end = System.nanoTime();
		
		System.out.printf("%s.factorial(%d)의 실행시간 : %d\n",
				calc.getClass().getSimpleName(), num, (end - start));
							//클래스이름 
		return result;
	}	
	
}
