package Graphs;

public class Neighbor {
    public int vertex;
    public Neighbor next;
    
	public Neighbor(int vertex,Neighbor next){
		this.vertex = vertex;
		this.next = next;
	}
}
