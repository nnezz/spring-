package ex01;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Greeter gt = new Greeter();
		gt.setFormat("%s 님,안녕하세요!");
		
		System.out.println(gt.greet("홍길동"));
	}

}
