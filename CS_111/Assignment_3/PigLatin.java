public class PigLatin{


	public static String translate(String original){

		if (original.equals("")){
			IO.reportBadInput();
			return "";
		}

		String result = new String();
		boolean vowel = false;
		String front = new String(original.substring(0,1));
		String frontup = new String(front.toUpperCase());

		if (frontup.equals("A")||frontup.equals("E")||frontup.equals("I")||frontup.equals("O")||frontup.equals("U")){
			vowel = true;
		}

		if (vowel == true){
			result = original+"way";
		}
		else{
			result = original.substring(1)+front+"ay";
		}
		return result;

	}
	
}