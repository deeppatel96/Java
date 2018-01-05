
public class BTNode<T> {
    T data;
    BTNode<T> left, right;
    BTNode(T data, BTNode<T> left, BTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
