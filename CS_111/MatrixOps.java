public class MatrixOps
{

	public static double[][] multiply(double[][] a, double[][] b)
	{
		double[][] c = new double[a.length][b[0].length];
	
		if (a[0].length == b.length)
		{
			for (int ia = 0; ia < a.length; ia++)
			{
				for (int jb = 0; jb < b[0].length; jb++)
				{
					for (int ja = 0; ja < a[0].length; ja++)
					{
							c[ia][jb] += a[ia][ja] * b[ja][jb];
					}
				}
			}
		}
		else
		{
			c = null;
		}
	
		return c;

	}

}