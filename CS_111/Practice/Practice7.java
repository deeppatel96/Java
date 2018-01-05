// Practice 7
public class Practice7{
	public static void main(String[] args){
		System.out.println("Give an upper limit.");
		int limit = IO.readInt();
		int total;
		int count;
		if(limit<=6){
			System.out.println("There are no magic numbers under this limit.");
		}
		else{
			System.out.println("The magic numbers are:");
		}
		while(limit>1){
			limit--;
			total = 0;
				for(count = 1;count<limit;count++)
					if(limit%count==0){
						total+=count;
					}
			if (total==limit){
				System.out.println(limit);
			}
		}
	}
}