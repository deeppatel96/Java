
public class homework{
	
	public static void main(String args[]){

		int x[] = new int[10];
		x[0] = 240;
		x[1] = 280;
		x[2] = 225;
		x[3] = 185;
		x[4] = 315;
		x[5] = 295;
		x[6] = 285;
		x[7] = 270;
		x[8] = 280;
		x[9] = 190;

		int y[] = new int[10];
		y[0] = 98;
		y[1] = 107;
		y[2] = 87;
		y[3] = 84;
		y[4] = 124;
		y[5] = 112;
		y[6] = 113;
		y[7] = 101;
		y[8] = 105;
		y[9] = 87;

		int xsum = 0;
		int ysum = 0;
		int xytotal = 0;
		int xsquare = 0;

		for(int i = 0; i<10; i++){
			xsum += x[i];
			ysum += y[i];
			xytotal += x[i]*y[i];
			xsquare += x[i]*x[i];
		}

		double b1 = (double) (10*xytotal - (xsum*ysum)) / (10*xsquare - xsum*xsum);
		double b0 = (double) (ysum - b1*xsum)/10;


		System.out.println(b1);
		System.out.println(b0);

		double xbar = xsum/10;
		double ybar = ysum/10;
		double topsum = 0;
		double bl = 0;
		double br = 0;


		for(int i = 0; i<10; i++){

			topsum += (x[i]-xbar)*(y[i]-ybar);
			bl += (x[i]-xbar)*(x[i]-xbar);
			br += (y[i]-ybar)*(y[i]-ybar);
		}

		double r = topsum / (Math.sqrt(bl*br));

		System.out.println(r);


	}


}