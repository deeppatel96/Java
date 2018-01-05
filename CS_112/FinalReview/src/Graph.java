// Spring 2014 Problem 2: Shortest Path
public class Graph {
	Neighbor[] adjLists;

	public int shortestPath(int x, int y){
		int[] distances = new int[adjLists.length];
		Queue<Neighbor> fringe = new Queue<Neighbor>();
		for(int i = 0; i < adjLists.length;i++){
			distances[i] = -1;
		}
		distances[x] = 0;
		for(Neighbor nbr = adjLists[x]; nbr!=null; nbr=nbr.next){
			distances[nbr.vnum] = 1;
			fringe.enqueue(nbr);
		}
		while(!fringe.isEmpty()){
			Neighbor temp = fringe.dequeue();
			for(Neighbor nbr = temp; nbr!=null; nbr=nbr.next){
				if(distances[nbr.vnum] == -1){
					distances[nbr.vnum] = 1+distances[temp.vnum];
					fringe.enqueue(nbr);
				}
				else if(nbr.vnum != x && distances[nbr.vnum] > 1+distances[temp.vnum]){
					distances[nbr.vnum] = 1+distances[temp.vnum];
				}
			}	
		}
		
		return distances[y];
		
	}
}
