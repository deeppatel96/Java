public class Longest{
	public static void main(String[] args){
		int numrepeat = 0, count = 0, where = 0;

		String s1 = "abaabacccaabbbba";

		for (int i=0; i<s1.length();){
			char c = s1.charAt(i);
			int start = i;
			i++;
			while(c==s1.chatAt(i)){
				i++;
			}

			if (i-start > numrepeat){
				numrepeat = i-start;
				where = start;
			}
		}
	}
}