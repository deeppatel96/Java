package Graphs;

public class GraphTest {

	public static void main(String[] args) {
		
		Neighbor n1 = new Neighbor(1,null);
		Neighbor n2 = new Neighbor(2,null);
		Neighbor n3 = new Neighbor(3,null);
		Neighbor n4 = new Neighbor(4,null);
		n1.next = n2;
		n3.next = n2;
		n4.next = n2;
		Vertex v1 = new Vertex("First",n1);
		Vertex v2 = new Vertex("Second",n2);
		Vertex v3 = new Vertex("Third",n3);
		Vertex v4 = new Vertex("Fourth",n4);
		Vertex v5 = new Vertex("Fifth",null);
		Vertex[] vertices = {v1,v2,v3,v4,v5};
		
		Graph graph = new Graph();
		graph.vertices = vertices;
		int[] x = graph.indegrees();
		for(int i = 0; i<x.length;i++){
			System.out.print(x[i]+",");
		}
		
	}

}
