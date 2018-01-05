package Graphs;

public class Vertex {
	String name;
	Neighbor neighbors; // adjacency linked lists for all vertices
	
	public Vertex(String name,Neighbor neighbors){
		this.name = name;
		this.neighbors = neighbors;
	}
}
