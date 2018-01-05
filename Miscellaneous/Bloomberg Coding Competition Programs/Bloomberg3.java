public class Bloomberg3{
	

	public static void main(String[] args){
		rugbyScore(17);
	}


	public static void rugbyScore(int x){

		if (x < 2){
			System.out.println("0 0 0");
			return;
		}

		for (int i = 0; i <=(x/7 +1); i = i+1){

			for(int j = 0; j < (x/3 +1); j = j+1){

				for(int k = 0; k < (x/2 +1); k = k+1){

					if((7*i + 3*j + 2*k) == x){
						System.out.println(i+" "+j+" "+k);
					}
				}
			}
		}


	}


}