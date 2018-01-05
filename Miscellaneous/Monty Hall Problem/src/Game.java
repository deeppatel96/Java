import java.util.Random;

public class Game {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Random rand2 = new Random();


		int  n;
		int pick;
		int show;
		int last;
		int rounds = 10000000;
		int isCar = 0;
		int notCar = 0;
		Door[] doors = new Door[3];
		doors[0] = new Door(false);
		doors[1] = new Door(false);
		doors[2] = new Door(false);
		
		for(int i = 0;i<rounds;i++){
		
		doors[0].makeGoat();
		doors[1].makeGoat();
		doors[2].makeGoat();

		n = rand.nextInt(3);
		doors[n].makeCar();
		pick = rand.nextInt(3);


		show = rand2.nextInt(3);
		while(doors[show].getValue() == true || show == pick){
			show = rand2.nextInt(3);
		}

		
		last = rand2.nextInt(3);
		while(last == pick || last == show)
		{
			last = rand2.nextInt(3);

		}		
		if(doors[last].getValue() == true){
			isCar++;
		}
		else{
			notCar++;
		}
	
			
	}
		
		System.out.println(isCar);
		System.out.println(notCar);
		
	}

}
