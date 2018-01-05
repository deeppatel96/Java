package Graphs;

public class Graph {
    Vertex[] vertices;

    // returns an array of indegrees of the vertices, i.e. return[i] is the
    // number of edges that are directed IN TO vertex i
    public int[] indegrees() {
    	
    	int[] in = new int[vertices.length];
    	
    	for(int i = 0; i<vertices.length;i++){
    		int x = 0;
    		for(int j = 0; j<vertices.length;j++){
    			Neighbor temp = vertices[j].neighbors;
    			while(temp!=null){
    				if(temp.vertex == i){
    					x++;
    				}
    				temp = temp.next;
    			}
    		}
    		in[i] = x;
    	}
    	return in;
    }
}




