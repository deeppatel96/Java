public class PracticeFinal2{


	public static void main(String[] args){

		System.out.println("Enter sentence to be reversed");
		String x = IO.readString();
		System.out.println(reverse(x));


	}


	public static String reverse(String sentence){
		String answer = "";
		sentence = sentence.toLowerCase();
		int numTemp = 0;
		String stringTemp = "";


		for (int i = 0;i<sentence.length();i++){

			if(sentence.charAt(i) == ' '){
				stringTemp = sentence.substring(numTemp,i);
				answer += reverseLetters(stringTemp)+" ";
				numTemp = i+1;
			}
			else if (sentence.charAt(i) == '.'){
				stringTemp = sentence.substring(numTemp,i);
				answer += reverseLetters(stringTemp);
				numTemp = i+1;			
			}

		}

		String first = answer.substring(0,1);
		first = first.toUpperCase();
		answer = first + answer.substring(1)+".";

		return answer;


	}

	public static String reverseLetters(String x){

		String answer = "";
		for (int i = x.length()-1; i>=0;i--){
			answer += x.charAt(i);
		}

		return answer;

	}



}