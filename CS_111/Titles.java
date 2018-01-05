public class Titles
{
	public static void main(String[] args)
	{
		String a = IO.readString();
		String b = IO.readString();
		String c = IO.readString();
		String[] answer = titles(a,b,c);
		for (int i = 0;i<=2;i++)
		{
			IO.outputStringAnswer(answer[i]);
		}


	}



	public static String[] titles(String a, String b, String c)
	{
		String book1;
		String book2;
		String book3;
		String oa = a;
		String ob = b;
		String oc = c;
		a.toLowerCase();
		b.toLowerCase();
		c.toLowerCase();
		if (a.startsWith("the "))
		{
			a = a.substring(4);
		}
		if (b.startsWith("the "))
		{
			b = b.substring(4);
		}
		if (c.startsWith("the "))
		{
			c = c.substring(4);
		}
		if (a.compareTo(b)<0 && a.compareTo(c)<0)
		{
			if(b.compareTo(c)<0)
			{
				book1 = oa;
				book2 = ob;
				book3 = oc;
			}
			else
			{
				book1 = oa;
				book2 = oc;
				book3 = ob;
			}
		}
		else if (b.compareTo(a)<0 && b.compareTo(c)<0)
		{
			if (a.compareTo(c)<0)
			{
				book1 = ob;
				book2 = oa;
				book3 = oc;
			}
			else
			{
				book1 = ob;
				book2 = oc;
				book3 = oa;
			}
		}
		else
		{
			if (a.compareTo(b)<0)
			{
				book1 = oc;
				book2 = oa;
				book3 = ob;
			}
			else
			{
				book1 = oc;
				book2 = ob;
				book3 = oa;
			}
		}
		String answer[] = {book1,book2,book3};

		return answer;


	}


}