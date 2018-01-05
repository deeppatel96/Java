public class StringRec
{
	// Main method
	public static void main(String[] args)
	{
		System.out.println("Enter RLE compressed text");
		String text = IO.readString();
		System.out.println(decompress(text));

	}

	// Decompress method
	public static String decompress(String compressedText)
	{
		// declare temporary variables
		char numTemp;
		char charTemp;


		// Recursion conditions/code
		if (compressedText.length() <= 1)
		{
			return compressedText;
		}
		else if (compressedText.charAt(0) == '0')
		{
			if (compressedText.length() <= 2)
			{
				return "";
			}
			else
			{
				compressedText = compressedText.substring(2);
				return decompress(compressedText);
			}
		}
		else if (Character.isDigit(compressedText.charAt(0)))
		{
			numTemp = compressedText.charAt(0);
			charTemp = compressedText.charAt(1);
			numTemp--;
			compressedText = numTemp+compressedText.substring(1);

			return charTemp+decompress(compressedText);
		}
		else
		{
			charTemp = compressedText.charAt(0);
			compressedText = compressedText.substring(1);

			return charTemp+decompress(compressedText);
		}


	}
}
