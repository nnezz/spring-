package ex01;

public class Greeter {
	private String format;

	public void setFormat(String format) {
		this.format = format;
	}
	
	public String greet(String name) { //인사하기 기능
		return String.format(format, name);
	}
}
