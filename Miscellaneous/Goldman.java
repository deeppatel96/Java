public class Goldman{
	

	public int get(int n){
	
		if(n == 0){
			return 1;
		}
		else if(n>=3){
			return get(n-3)+get(n-2)+get(n-1);
		}
		else if(n>=2){
			return get(n-2)+get(n-1);
		}
		else if(n>=1){
			return get(n-1);
		}
		return 0;
	}

public static void main(String args[]){

	Goldman man = new Goldman();
	System.out.println(man.get(6));

}
	
}