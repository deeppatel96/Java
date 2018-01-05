import java.util.Random;

public class DiceRoller {

	public static void main(String[] args) {

		Random rand = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		int[] table = new int[100];
		int[] freq = new int[16];
		


		for(int i = 0; i<100; i++){
			int n = rand.nextInt(6)+1;
			int j = rand2.nextInt(6)+1;
			int k = rand3.nextInt(6)+1;
			table[i] = n+j+k;
			freq[table[i]-3]++;
			//System.out.println(table[i]);
		}
		for(int i = 0; i<freq.length; i++){
			System.out.println(i+3+": "+freq[i]);
		}
		
	}

}
