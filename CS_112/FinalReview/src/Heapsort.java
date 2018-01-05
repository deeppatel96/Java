
public class Heapsort {
	// sorts an array in ascending order using heapsort
	
	public static <T extends Comparable<T>> void sort(T[] list) {
		buildHeap(list);
		sortHeap(list);
	}
	
	// sifts down in an array[0..n-1] starting at index k
	private static <T extends Comparable<T>> void siftDown(T[] list, int k, int n) {
		
		while(2*k+1 < n){
			int max = 2*k+1;
			int right = 2*k+2;
			if(right<n){
				int c = list[right].compareTo(list[max]);
				if(c>0){max = right;}
			}
			int c = list[k].compareTo(list[max]);
			if(c<0){
				T temp = list[k];
				list[k] = list[max];
				list[max] = temp;
				k = max;
			} else{
				break;
			}
		}

	}

	// arranges items in list in heap order in LINEAR TIME, using repeated sift downs
	private static <T extends Comparable<T>> void buildHeap(T[] list) {
		
		for(int i = list.length-1; i>=0; i--){
			siftDown(list,i,list.length);
		}
		
	}
	//sorts a heap-ordered array
	private static <T extends Comparable<T>> void sortHeap(T[] list) {
		
		for(int i = list.length-1; i>0; i--){
			T temp = list[0];
			list[0] = list[i];
			list[i] = temp;
			siftDown(list,0,i);
		}
		
	}
}