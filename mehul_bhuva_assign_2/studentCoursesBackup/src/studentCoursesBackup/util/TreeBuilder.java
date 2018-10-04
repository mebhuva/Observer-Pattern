package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {
	 Node root; 
	  
	    // Constructor 
	    public TreeBuilder() 
	    { 
	        root = null; 
	    } 
	  
	    // This method mainly calls deleteRec() 
	    private void deleteKey(int key) 
	    { 
	        root = this.deleteRec(root, key); 
	    } 
	  
	    /* A recursive function to insert a new key in BST */
	   private Node deleteRec(Node root, int key) 
	    { 
	        /* Base Case: If the tree is empty */
	        if (root == null)  return root; 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.getKey()) 
	            root.setLeft(this.deleteRec(root.getLeft(), key)); 
	        else if (key > root.getKey()) 
	            root.setRight(this.deleteRec(root.getRight(), key)); 
	  
	        // if key is same as root's key, then This is the node 
	        // to be deleted 
	        else
	        { 
	            // node with only one child or no child 
	            if (root.getLeft() == null) 
	                return root.getRight(); 
	            else if (root.getRight() == null) 
	                return root.getLeft(); 
	  
	         // node with two children: Get the inorder successor (smallest
	            // in the right subtree)
	            root.setKey(this.minValue(root.getRight()));
	            root.setCourseList(this.minValueCourse(root.getRight()));
	  
	            // Delete the inorder successor 
	            root.setRight(this.deleteRec(root.getRight(), root.getKey())); 
	        } 
	  
	        return root; 
	    } 
	    
	    private ArrayList<String> minValueCourse(Node root)
	    {
	        int minv = root.getKey();
	        ArrayList<String> temp = root.getCourseList();
	        while (root.getLeft() != null)
	        {
	            temp = root.getLeft().getCourseList();
	            minv = root.getLeft().getKey();
	            root = root.getLeft();
	        }
	        return temp;
	    }

		int minValue(Node root) 
	    { 
	        int minv = root.getKey(); 
	        while (root.getLeft() != null) 
	        { 
	            minv = root.getLeft().getKey(); 
	            root = root.getLeft(); 
	        } 
	        return minv; 
	    } 
	  
	  
	    /* A recursive function to insert a new key in BST */
	    private void insertRec(Node newNode) 
	    { 
	    	root = this.insertRec(root, newNode);
	    } 
	    
	    private Node insertRec(Node root, Node newNode) 
	    {
	    	int key = newNode.getKey();
	        /* If the tree is empty, return a new node */
	        if (root == null) 
	        { 
	            root = new Node(newNode); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.getKey())
	            root.setLeft(this.insertRec(root.getLeft(), newNode));
	        else if (key > root.getKey())
	            root.setRight(this.insertRec(root.getRight(), newNode));
	  
	        /* return the (unchanged) node pointer */
	        return root; 
	    }   
}
