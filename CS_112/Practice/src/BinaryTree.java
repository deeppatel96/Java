
public class BinaryTree {

	public static void main(String[] args) {
		
		BTNode<String> T1 = new BTNode<String>("no",null,null);
		BTNode<String> T2 = new BTNode<String>("yes",null,null);
		T2.left =  new BTNode<String>("ok",null,null);
		T1.left =  new BTNode<String>("ok",null,null);
		T1.left.right =  new BTNode<String>("ok",null,null);

		
		System.out.println(isomorphic(T1,T2));

	}

	public static <T> boolean isomorphic(BTNode<T> T1,BTNode<T> T2){
				
		if(T1 == null && T2 == null){
			return true;
		}
		else if(T1 == null || T2 == null){
			return false;
		}
		else if(isomorphic(T1.left,T2.left) && isomorphic(T1.right,T2.right)){
			return true;
		}
		else{
			return false;
		}
	
	}
	
}
