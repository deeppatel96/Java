public class Cipher{
	

	public static void main(String[] args)
	{
		System.out.println("Enter secret code as String");
		String a = IO.readString();
		IO.outputStringAnswer(cipher(a));
	}

	public static String cipher(String x)
	{
		char temp;
		int a = 0;
		int b;
		String lowx = x.toLowerCase();
		String code = "";
		for (int i = 0; i<lowx.length();i++)
		{
			a = (int) lowx.charAt(i);

			if (a == 32)
			{
				b = a;
			}
			else if (a == 97)
			{
				b = 122;
			}
			else if (a == 48)
			{
				b = 57;
			}
			else
			{
				b = a-1;
			}
		code += (char) b;

		}


		return code;


	}
}