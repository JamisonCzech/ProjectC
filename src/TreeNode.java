//Interface Class
public interface TreeNode<T> {

    TreeNode<T>[] getChildren();

    TreeNode<T> getLeftChild();

    TreeNode<T> getRightChild();

    void setLeftChild(TreeNode<T> node);

    void setRightChild(TreeNode<T> node);

    void setData(T data);

    T getData();

}