package game;

public class Student implements Info {

	private String name;

	public Student(String name) {
		this.name = name;
	}
	public void greet() {
		System.out.println("Hello there!!");
		
	}
	@Override
	public void showInfo() {
		System.out.println("I am "+ name);
		
	}
}
