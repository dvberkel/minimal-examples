package example;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		HelloWorld object = new HelloWorld();
		
		System.out.println(object.greeting());
	}
	
	private String message = "Hello World";
	
	public String greeting() {
	
		return message;
	}
}
