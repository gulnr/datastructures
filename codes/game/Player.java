package game;

public class Player extends GameObject implements Info {
	private int id;
	
	
	public Player(int id) {
		super();
		this.id = id;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("player draw");
	}
	
	public void someMethod(){
		
		
	}

	public void showInfo() {
		System.out.println("Player id="+id);
		
	}

}
