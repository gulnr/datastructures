package game;

public class Test {

	public static void main(String[] args) {
		Player myplayer= new Player(23);
		myplayer.someMethod();
		//myplayer.draw();
		//GameObject myobject=new GameObject();
		//abstract classes exist  to be extended, they can not be instantiated
		
		Menu myMenu=new Menu();
		//myMenu.draw();
		
		Student s=new Student("Ayse");
		
		GameObject[] gameObjects=new GameObject[2];
		gameObjects[0]=myplayer;
		gameObjects[1]=myMenu;
		
		for(GameObject obj: gameObjects){
			
			obj.draw();
		}
		
		Info[] infoObjects=new Info[2];
		infoObjects[0]=myplayer;
		infoObjects[1]=s;
		
		for(Info i:infoObjects){
			i.showInfo();
			
		}
			
		
	}
	

}
