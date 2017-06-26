package thiskeyword;

public class Invokeconstrutor {
	int id;
	String name;
	float fee;

	Invokeconstrutor(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	Invokeconstrutor(int id, String name, float fee){
		this(id, name);
		this.fee = fee;	
	}
	void display() {
		System.out.println(id + " " + name + " " + fee);
	}

	public static void main(String[] args) {
		Invokeconstrutor s1 = new Invokeconstrutor(111, "Hoang");
		Invokeconstrutor s2 = new Invokeconstrutor(322, "Nam", 23);
		s1.display();
		s2.display();
	}
}
