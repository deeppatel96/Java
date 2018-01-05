public class ReverseWords
{
	

	public static void main(String[] args)
	{
		System.out.println("Enter a sectence");
		String a = IO.readString();
		IO.outputStringAnswer(reverseWords(a));
	}


	public static String reverseWords(String x)
	{
		x = x.toLowerCase();

		int count = x.length()-1;
		String temp;
		String answer = "";
		for(int i = x.length()-1; i>=0; i--)
		{
			if (x.charAt(i) == ' ')
			{
				temp = x.substring(i+1,count);
				count = i;
				answer+=temp+" ";
			}
			else if (i == 0)
			{
				temp = x.substring(0,count);
				count = 0;
				answer+=temp+".";
			}
		}

		String first = answer.substring(0,1);
		first = first.toUpperCase();
		answer = first+answer.substring(1);

		return answer;


	}


}