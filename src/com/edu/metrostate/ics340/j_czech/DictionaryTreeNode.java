/**
 * 
 */
package com.edu.metrostate.ics340.j_czech;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 *         (jamisonczech@gmail.com) </A>
 *
 *
 */
public class DictionaryTreeNode<T extends Comparable<T>> implements TreeNode<T> {

	// package access variables
	T data;
	TreeNode<T> left;
	TreeNode<T> right;


	/**
	 * constructor initializes data and makes this a leaf node
	 * 
	 * @param initalData parameter that passes entries from a file
	 */
	public DictionaryTreeNode(T initalData) {
		this.data = initalData;
		this.left = null;
		this.right = null;
	}
	
	
	/**
	 * inserts string into BST <b>Postcondition:</b>
	 * 
	 * @param insertWord
	 *            inserts the word into BST
	 */
	public void insert(T insertWord) {
		// int one = ((String) insertWord).compareToIgnoreCase((String) data);
		// System.out.println("wordOne "+ insertWord + " wordTwo " + data +"
		// comparison: "+ one);
		if (insertWord.compareTo(getData()) < 0) {
			if (getLeftChild() == null) {
				setLeftChild(new DictionaryTreeNode<T>(insertWord));
			} else {
				((DictionaryTreeNode<T>) getLeftChild()).insert(insertWord);
			}
		} else if (insertWord.compareTo(getData()) > 0) {
			if (getRightChild() == null) {
				setRightChild(new DictionaryTreeNode<T>(insertWord));
			} else {
				((DictionaryTreeNode<T>) getRightChild()).insert(insertWord);
			}
		}

	}
	
	

	/**
	 * sets the left node
	 * 
	 * @param node
	 *            is the node
	 */
	@Override
	public void setLeftChild(TreeNode<T> node) {
		left = node;

	}

	/**
	 * sets the right node data
	 * 
	 * @param node
	 *            is the node
	 */
	@Override
	public void setRightChild(TreeNode<T> node) {
		right = node;

	}

	/**
	 * gets the node data
	 * 
	 * @param newData is is the node
	 *            
	 */
	@Override
	public void setData(T newData) {
		data = newData;
	}

	/**
	 * Accessor method gets the left node data
	 * 
	 */
	@Override
	public TreeNode<T> getLeftChild() {
		return left;
	}

	/**
	 * Accessor method gets the right node data
	 * 
	 */
	@Override
	public TreeNode<T> getRightChild() {
		return right;
	}

	/**
	 * Accessor method gets the node data
	 */
	@Override
	public T getData() {
		return data;
	}

	
	/**
	 * returns an array which contains the children of the node
	 */
	@Override
	public TreeNode<T>[] getChildren() {
		// TODO Auto-generated method stub
		return null;
	}
}// end class DictionaryTreeNode
