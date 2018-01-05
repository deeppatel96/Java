
public class Door {

	private boolean car;
	
	
	public Door(boolean car){
		this.car = car;
	}
	
	public boolean getValue(){
		return car;
	}
	
	public void makeCar(){
		car = true;
	}
	
	public void makeGoat(){
		car = false;
	}
	
	public String toString(){
		if (car ==true){
			return "CAR";
		}
		else
		{
			return "GOAT";
		}
	}
}
