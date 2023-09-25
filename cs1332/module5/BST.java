package cs1332.module5;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if(Objects.equals(data, null)) {
    		throw new IllegalArgumentException();
    	}else if(Objects.equals(root, null)) {
    		root = new BSTNode<T>(data);
    	}
    	else {
    		helpAdd(root, data);
    	}
    }
    
    private void helpAdd(BSTNode<T> cur,T data) {

    	if(cur.getData().compareTo(data)==0) return;
    	else if(cur.getData().compareTo(data)>0) {
    		
    		if(Objects.equals(cur.getLeft(), null)) {
    			size++;
    			cur.setLeft(new BSTNode<T>(data));
    		}else {
    			helpAdd(cur.getLeft(),data);
    		}
    	}
    	else if(cur.getData().compareTo(data)<0) {
    		
    		if(Objects.equals(cur.getRight(), null)) {
    			size++;
    			cur.setRight(new BSTNode<T>(data));
    		}else {
    			helpAdd(cur.getRight(),data);
    		}
    	}
    	
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if(Objects.equals(data, null)) {
    		throw new IllegalArgumentException();
    	}else if(Objects.equals(root, null)) {
    		throw new NoSuchElementException();
    	}else {
    		return helpRemove(root, data);
    	}
    }
    
    private T helpRemove(BSTNode<T> cur, T data) {
    	
    	if(cur.getData().compareTo(data)==0) {
    		if(Objects.equals(cur.getLeft(),null) && Objects.equals(cur.getRight(), null)) {
    			zeroChildRemove(null, cur,data);
    		}else if(Objects.equals(cur.getLeft(),null) || Objects.equals(cur.getRight(), null)) {
    			zeroChildRemove(null, cur,data);
    		}
    	}
    	
    }
    //子の数ごとにメソッドを分ける
    private T zeroChildRemove(BSTNode<T> parent, BSTNode<T> cur, T data) {
    	
    }
    private T oneChildRemove(BSTNode<T> parent, BSTNode<T> cur, T data) {
    	
    }
    private T twoChildRemove(BSTNode<T> parent, BSTNode<T> cur, T data) {
 	
 }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}