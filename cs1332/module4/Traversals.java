package cs1332.module4;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	List<T> res = new ArrayList<>();
    	return helper_preorder(res, root);
    
    }
    
    private List<T> helper_preorder(List<T> res, TreeNode<T> cur) {
    	
    	if(Objects.equals(cur, null)) return res;
    	res.add(cur.getData());
        helper_preorder(res, cur.getLeft());
        helper_preorder(res, cur.getRight());
        
    	return res;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	List<T> res = new ArrayList<>();
    	return helper_inorder(res, root);
    }
    
    private List<T> helper_inorder(List<T> res, TreeNode<T> cur) {
    	
    	if(Objects.equals(cur, null)) return res;
    	helper_inorder(res, cur.getLeft());
    	res.add(cur.getData());
    	helper_inorder(res, cur.getRight());
    	
    	return res;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	List<T> res = new ArrayList<>();
    	return helper_postorder(res, root);
    }
    
    private List<T> helper_postorder(List<T> res, TreeNode<T> cur) {
    	
    	if(Objects.equals(cur, null)) return res;
    	helper_postorder(res, cur.getLeft());
    	helper_postorder(res, cur.getRight());
    	res.add(cur.getData());
    	
    	return res;
    }
}