public class Compress{
	

	public static String compress(String original){
		String compressed = new String("");
		int count = 1;
		for (int k=0;k<original.length()-1;k++){
			if (original.charAt(k)==original.charAt(k+1)){
				count++;
			}
			else{
				if (count>1){
					compressed+= Integer.toString(count);
					compressed+= original.substring(k,k+1);
				}
				else{
					compressed+= original.substring(k,k+1);
				}
				count=1;
			}
		}
		if (count>1){
					compressed+= Integer.toString(count);
					compressed+= original.substring(original.length()-1);
				}
				else{
					compressed+= original.substring(original.length()-1);
				}
		return compressed;
	}
}