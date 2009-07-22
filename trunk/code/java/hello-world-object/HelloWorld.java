class HelloWorld {
	
	private String greeting = "Hello World";
	
	public static void main(String[] args) {
		
		HelloWorld object = new HelloWorld();
		
		object.greet();
	}
	
	public void greet() {
		
		System.out.println(greeting);	
	}
	
	
}
