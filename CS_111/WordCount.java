public class WordCount{
	

	public static int countWords(String original, int minLength){
		int words = 0;
		int length;
		if (minLength<0){
			IO.reportBadInput();
		}
		int temp = 0;
		for(int k=0;k<original.length();k++){

			if (original.charAt(k) == ' '){
				length = numberOfLetters(original.substring(temp,k));
				temp = k+1;
				if (length>=minLength){
					words++;
				}
			}
		}

		length = numberOfLetters(original.substring(temp));
		if (length>=minLength){
			words++;
		}
		return words;
	}

	public static int numberOfLetters(String x){
		int count = 0;
		for (int k=0; k<x.length(); k++){
			if (Character.isLetter(x.charAt(k)) == true){
				count++;
			}
		}
		return count;
	}
}