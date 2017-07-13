/**
 * 
 */

/**
 * @author Jamison Czech citation http://www.cs.colorado.edu/~main/docs/
 */
public class Tree<T extends Comparable<T>> {
	DictionaryTreeNode<T> root;

	/**
	 * constructor initializes an empty Tree
	 */
	public Tree() {
		root = null;
	}

	/**
	 * Checks to see if root is equal to null, if so it creates a new node.
	 * 
	 * @param insertWord
	 *            inserts the word If root is null it begins a new node
	 * 
	 *            <b>Postcondition:</b> creates nodes based on the
	 *            <CODE>insert </CODE> method in located in DictionaryTreeNode
	 *            class
	 */
	public void insertNode(T insertWord) {
		if (root == null) {
			root = new DictionaryTreeNode<T>(insertWord);
		} else {
			root.insert(insertWord);
		}
	}

	/**
	 * Uses a preorder traversal to print the data from each node at or below
	 * this node of the binary tree.
	 */
	public void preorderTraversal() {
		preorderHelper(root);
	} // end method preorderTraversal

	// recursive method to perform preorder traversal
	private void preorderHelper(DictionaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.printf("%s\n", node.getData()); // output node data
		preorderHelper((DictionaryTreeNode<T>) node.left);
		preorderHelper((DictionaryTreeNode<T>) node.right);
	}

	/**
	 * public method that returns the number of leaves
	 * 
	 * @return countLeavesHelper(root) returns the number of leaves
	 *         <b>Postcondition:</b> returns the number of leaves
	 *         <CODE>System.out.println( countLeaves())</CODE>
	 **/
	public int countLeaves() {
		return countLeavesHelper(root);
	} // end method preorderTraversal

	private int countLeavesHelper(DictionaryTreeNode<T> node) {
		// Return the number of leaves in the tree to which node points.
		if (node == null)
			return 0; // An empty tree has no leaves.
		else if (node.left == null && node.right == null)
			return 1; // Node is a leaf.
		else
			return countLeavesHelper((DictionaryTreeNode<T>) node.left)
					+ countLeavesHelper((DictionaryTreeNode<T>) node.right);
	} // end countNodes()

	/**
	 * 
	 * @return depth of BST * <b>Postcondition:</b> returns the max number of
	 *         links between nodes
	 */
	public int depthOfBST() {
		return depthOfBSTHelper(root, 0);
	}

	private int depthOfBSTHelper(DictionaryTreeNode<T> node, int depthOf) {
		int leftDepth = depthOf;
		int rightDepth = depthOf;

		if (node.left != null) {
			leftDepth = depthOfBSTHelper((DictionaryTreeNode<T>) node.left, depthOf + 1);
		}
		if (node.right != null) {
			rightDepth = depthOfBSTHelper((DictionaryTreeNode<T>) node.right, depthOf + 1);
		}

		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

	/**
	 * finds a node in the tree with the specified word
	 * 
	 * @param word, word
	 *            String to be compared to the String in each node
	 * @return the object found, not the object searched for or null
	 */
	public T findWord(T word) {
		return findWordHelper(word, root);
	}

	/**
	 * finds a node in the tree with the specified word, returns the word check
	 * for null subtree FIRST, before trying to get subtree.item, subtree.left,
	 * or subtree.right
	 * 
	 * @param word
	 *            String to be compared to the word in each node
	 * @param node
	 *            root of the current subtree <b>Postcondition:</b>
	 * @return the object found (NOT the object searched for!) or null
	 */
	private T findWordHelper(T word, DictionaryTreeNode<T> node) {

		if (node == null) {
			return null; // not found
		}
		int comparison = word.compareTo(node.data);
		if (comparison == 0) {
			return node.data;
		}
		if (comparison < 0) {
			return findWordHelper(word, (DictionaryTreeNode<T>) node.left);
		} else {
			return findWordHelper(word, (DictionaryTreeNode<T>) node.right);
		}
	}

	/**
	 * Finds out how many nodes are in the BST. <b>Postcondition:</b>
	 * 
	 * @return the number of nodes in this subtree
	 */
	public int size() {
		return size(root);
	}

	/**
	 * computes the number of nodes in the subtree total size is the size of the
	 * left subtree, plus the size of the right subtree, plus one for the root
	 * of this subtree
	 * 
-td-63sD * @return the number of nodes in the subtree
	 */
	private int size(DictionaryTreeNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return size((DictionaryTreeNode<T>) node.left) + 1 + size((DictionaryTreeNode<T>) node.right);
		}
	}

	/**
	 * Uses an inorder traversal to print the data from each node at or below
	 * this node of the binary tree, with indentations to indicate the depth of
	 * each node.
	 * 
	 * @param  depth
	 *            depth the depth of this node (with 0 for root, 1 for the
	 *            root's children, and so on)( <b>Precondition:</b>
	 *            <CODE>int depth</CODE> is the depth of this node.
	 *            <b>Postcondition:</b> The data of this node and all its
	 *            descendants have been written by
	 *            <CODE>System.out.println( )</CODE> using an inorder traversal.
	 *            The indentation of each line of data is four times its depth
	 *            in the tree. A dash "--" is printed at any place where a child
	 *            has no sibling.
	 **/
	public void displayBST(int depth) {
		displayBSTHelper(depth, root);
	}

	private void displayBSTHelper(int depth, TreeNode<T> node) {
		int i;

		// Print the indentation and the data from the current node:
		for (i = 1; i <= depth; i++)
			System.out.print("    ");
		System.out.println(node.getData());

		// Print the left subtree (or a dash if there is a right child and no
		// left child)
		if (node.getLeftChild() != null)
			displayBSTHelper(depth + 1, node.getLeftChild());
		else if (node.getRightChild() != null) {
			for (i = 1; i <= depth + 1; i++)
				System.out.print("    ");
			System.out.println("--");
		}

		// Print the right subtree (or a dash if there is a left child and no
		// left child)
		if (node.getRightChild() != null)
			displayBSTHelper(depth + 1, node.getRightChild());

		else if (node.getLeftChild() != null) {
			for (i = 1; i <= depth + 1; i++)
				System.out.print("    ");
			System.out.println("--");
		}
	}// end method displayBSTHelper

	/**
	 * traversal to print the data from each node at or below this node of the
	 * binary tree, with indentations to indicate the depth of each node.
	 * 
	 * @param level
	 *            the depth of this node (with 0 for root, 1 for the root's
	 *            children , etc...)( <b>Precondition:</b> <CODE>depth</CODE>
	 */
	public void printBinaryTree(int level) {
		printBinaryTreeHelper(root, level);
	}

	private void printBinaryTreeHelper(TreeNode<T> root, int level) {
		if (root == null)
			return;
		printBinaryTreeHelper(root.getRightChild(), level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------__" + root.getData());
		} else
			System.out.println(root.getData());
		printBinaryTreeHelper(root.getLeftChild(), level + 1);
	}

	
	/**
	 * traversal to print the data from each node at or below this node of the
	 * binary tree, with indentations to indicate the depth of each node.
	 * 
	 * 
	 */
	public void print() {
		print("", root, false);
	}

	private void print(String prefix, TreeNode<T> treeNode, boolean isLeft) {
		if (treeNode != null) {
			System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + treeNode.getData());
			print(prefix + (isLeft ? "|   " : "    "), treeNode.getLeftChild(), true);
			print(prefix + (isLeft ? "|   " : "    "), treeNode.getRightChild(), false);
		}
	}

	public TreeNode<T> getRoot() {
		return root;

	}	
	

	public TreeNode<T> getParent(String word) {
		return getParentHelper(word, root, null);
	}

	private TreeNode<T> getParentHelper(String word, TreeNode<T> root, TreeNode<T> parent) {
		if (root == null) {
			return null;
		} else {
			if (word.compareTo((String) root.getData()) < 0) {
				return getParentHelper(word, root.getLeftChild(), root);

			} else if (word.compareTo((String) root.getData()) > 0) {
				return getParentHelper(word, root.getRightChild(), root);
			} else {
				return parent;
			}
		}
	}

}// end class tree
