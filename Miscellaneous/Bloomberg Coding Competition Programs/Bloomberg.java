public class Bloomberg{
	

	public static void main(String[] args){

		String X = "B95";
		String Y = "101101";
		int ans = baseArithmetic(X, Y);
		System.out.println(ans);
		
	}


	public static int baseArithmetic(String X, String Y){

		int minX = minBase(X);
		int minY = minBase(Y);
		int X_10 = xBaseToTenBase(X, minX);
		int Y_10 = xBaseToTenBase(Y, minY);

		return X_10+Y_10;

	}

	public static int xBaseToTenBase(String X, int minBase){

		int xLength = X.length();
		int currPlace = 1;
		int ans = 0;
		int currNum = 0;
		for (int i = xLength-1; i >= 0; i = i - 1){
			currNum = charToBase(X.charAt(i))-1;
			ans = ans + currNum*currPlace;
			currPlace = currPlace*minBase;
		}

		return ans;

	}


	public static int minBase(String X){

		X = X.toUpperCase();

		int highestBase = 2;
		int currBase = 0;
		int xLength = X.length();
		for(int j = 0; j < xLength; j = j+1){
			currBase = charToBase(X.charAt(j));
			if (currBase > highestBase){
				highestBase = currBase;
			}
		}

		return highestBase;
	}


	public static int charToBase(char curr){

		if(curr == '0'){
			return 1;
		}
		else if(curr == '1'){
			return 2;
		}
		else if(curr == '2'){
			return 3;
		}
		else if(curr == '3'){
			return 4;
		}
		else if(curr == '4'){
			return 5;
		}
		else if(curr == '5'){
			return 6;
		}
		else if(curr == '6'){
			return 7;
		}
		else if(curr == '7'){
			return 8;
		}
		else if(curr == '8'){
			return 9;
		}
		else if(curr == '9'){
			return 10;
		}
		else if(curr == 'A'){
			return 11;
		}
		else if(curr == 'B'){
			return 12;
		}
		else if(curr == 'C'){
			return 13;
		}
		else if(curr == 'D'){
			return 14;
		}
		else if(curr == 'E'){
			return 15;
		}
		else if(curr == 'F'){
			return 16;
		}

		return 0;

	}


}










