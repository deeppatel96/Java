package apps;

import structures.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MST {
	
	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	public static PartialTreeList initialize(Graph graph) {
		
		// Step 1
		PartialTreeList L = new PartialTreeList();
		Vertex[] v = graph.vertices;
				
		// Step 2
		for(int i = 0; i<graph.vertices.length;i++){
			
			// Part 1 & 2
			PartialTree T = new PartialTree(v[i]);
				
			// Part 3
			MinHeap<PartialTree.Arc> P = T.getArcs();
			
			// Part 4
			Vertex.Neighbor temp = v[i].neighbors;
			
			while(temp!=null){
				Vertex v2 = temp.vertex;
				int weight = temp.weight;
				PartialTree.Arc arc = new PartialTree.Arc(v[i],v2,weight);
				P.insert(arc);
				temp = temp.next;
			}
		
			// Part 5
			L.append(T);
		}
		
		return L;
		
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {
		
		PartialTreeList L = ptlist;
		ArrayList<PartialTree.Arc> mst = new ArrayList<PartialTree.Arc>();
		
		while(L.size()>1){
			// Step 3
			PartialTree PTX = L.remove();
			MinHeap<PartialTree.Arc> PQX = PTX.getArcs();
			
			// Step 4
			PartialTree.Arc alpha = PQX.deleteMin();
			
			//5 while alpha's v2 is already in the PTX partial tree
			while(PTX.getRoot().name.equals(alpha.v2.getRoot().name)){
				alpha = PQX.deleteMin();
			}
			
			// Step 6
			mst.add(alpha);
			
			// Step 7
			PartialTree PTY = L.removeTreeContaining(alpha.v2);
			
			// Step 8
			PTX.merge(PTY);
			L.append(PTX);
			

		} // Step 9: run through loop again if more than 1 PT remaining

		return mst;
	}
}
