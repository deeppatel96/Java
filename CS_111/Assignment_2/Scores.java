// Problem 1
public class Scores{
	public static void main(String[] args){
		System.out.println("What is the number of judges on the panel?");
		int judges = IO.readInt();
		while (judges<=2){
			IO.reportBadInput();
			System.out.println("What is the number of judges on the panel?");
			judges = IO.readInt();}

		int i = 1;
		double total = 0;
		double lowest = 10;
		double highest = 0;
		while (i<=judges){
		System.out.println("Enter a judge's score");
		double score = IO.readDouble();
			while (score<0.0 || score>10.0){
				IO.reportBadInput();
				System.out.println("Enter a judge's score");
				score = IO.readDouble();}
		if (score<lowest){
			lowest = score;}
		if (score > highest){
			highest = score;}
		total+=score;
		i++;}
		double avg = (total-highest-lowest)/(judges-2);
		IO.outputDoubleAnswer(avg);
	}
}