public class Pyramid{
	public static void main(String[] args){
	System.out.println("Enter height for pyramid:");
	int h = IO.readInt();

	for (int i=1;i<=h;i++){
		for(int j=1;j<=(h-i);j++){
			System.out.print(" ");}
		for(int k=1;k<=i;k++)
		System.out.print("*");}
		System.out.println("");}
	
}