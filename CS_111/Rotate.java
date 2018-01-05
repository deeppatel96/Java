public class Rotate{
	

	public static void main(String[] args){

	int[][] a = {
	{4, 3, 5, 6},
	{1, 5, 8, 2},
	{4, 7, 1, 0},
	{5, 1, 5, 8},
	{1, 8, 4, 2}
	};
	System.out.println(a);

	for (int i = 0; i<=1;i++){
	int[] temp = a[i];
	a[i] = a[4-i];
	a[4-i] = temp;
	}

	for (int i = 0; i<=4;i++){
		for (int j = 0; j<=1;j++){
		int temp = a[i][j];
		a[i][j] = a[i][3-j];
		a[i][3-j] = temp;
		}
	}
	System.out.println(a);
	}
}