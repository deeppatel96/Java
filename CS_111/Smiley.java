public class Smiley{
	public static void main(String[] args){
		System.out.println("Enter size:");
		int size = IO.readInt();
		Picasso.moveRight(7);
		Picasso.moveDown(7);
		Picasso.drawCircle(size);
		Picasso.moveLeft(2);
		Picasso.moveUp(2);
		Picasso.drawCircle(size/5);
		Picasso.moveRight(4);
		Picasso.drawCircle(size/5);
		Picasso.moveDown(4);
		Picasso.moveLeft(4);
		Picasso.drawLineDown(1);
		Picasso.moveDown(1);
		Picasso.drawLineRight(4);
		Picasso.moveRight(4);
		Picasso.moveUp(1);
		Picasso.drawLineDown(1);
	}
}