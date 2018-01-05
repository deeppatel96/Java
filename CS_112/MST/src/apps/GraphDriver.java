package apps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import structures.Vertex;
import structures.Graph;



public class GraphDriver{

	public static void main(String[] args)
		throws IOException {
			
			Scanner sysin = new Scanner(System.in);
			System.out.print("Enter graph file name: ");
			String graphName = sysin.next();

			// create new Graph object
			Graph graph = new Graph(graphName);

			Vertex a = new Vertex("A");
			Vertex e = new Vertex("E");

			
			PartialTreeList L = MST.initialize(graph);
//			System.out.println(L.size());
//			System.out.println(L.removeTreeContaining(a));
//			System.out.println(L.size());
//			System.out.println(L.remove());
//			System.out.println(L.size());
//			System.out.println(L.remove());
//			System.out.println(L.size());
//			System.out.println(L.remove());
//			System.out.println(L.size());
//
//			
			ArrayList<PartialTree.Arc> mst = MST.execute(L);
			for(int i = 0;i<mst.size();i++){
		    	System.out.println(mst.get(i));
			}
			


	
	}

}



