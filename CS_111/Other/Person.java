public class Person
{
	private String name;
	private int[] birthday;

	public static void main(String[] args)
	{
		System.out.println("Enter the number of people whose info you want to enter:");
		int x = IO.readInt();
		Person[] data = new Person[x];
		System.out.println("Enter a list of the people's names, bday month, and bday day");
		String a;
		int b;
		int c;
		for (int i = 0; i<x; i++)
		{
			a = IO.readString();
			b = IO.readInt();
			c = IO.readInt();
			data[i] = new Person(a,b,c);
		}
		String p = "";
		int[] bday = new int[2];
		if (p.equals("exit") == false)
		{
			System.out.println("Give a person's name to get their bday. Enter exit to exit.");
			p = IO.readString();
			for (int i = 0; i<x;i++)
				{
					if ((data[i].getName()).equals(p))
					{
						bday = data[i].getBirthday();
					}

				}
				for (int j = 0; j<=1;j++)
				{
					System.out.println(bday[j]);
				}
		}

	}

	public Person(String name, int month, int day)
	{
		this.name = name;
		this.birthday = new int[2];
		this.birthday[0] = month;
		this.birthday[1] = day;
	}

	public int[] getBirthday()
	{
		return this.birthday;
	}

	public String getName()
	{
		return this.name;
	}

	public String duplicate()
	{
		return this.name;
	}

}
