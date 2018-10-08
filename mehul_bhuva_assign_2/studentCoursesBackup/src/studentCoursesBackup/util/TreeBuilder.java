package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

/**
 * @author Mehul Reference Link
 *         https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 *         This Class basically creates Tree Data structure This Class use
 *         Binary Search Tree for all the insert , Search and Print Operation
 */
public class TreeBuilder {

	Node root;
	ArrayList<String> stringList = new ArrayList<String>();

	/**
	 * Constructor used to initialize root to null value
	 */
	public TreeBuilder() {
		root = null;
	}

	/**
	 * @param newNode
	 *            This method internally calls recursive method insertRec to insert
	 *            new node
	 */
	public void insert(Node newNode) {
		try {
			root = this.insertRec(root, newNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * Recursive function to insert record in the tree
	 * 
	 * @param root
	 * @param newNode
	 * @return inserted record
	 */
	private Node insertRec(Node root, Node newNode) {

		int key = newNode.getKey();
		if (root == null) {
			try {
				root = new Node(newNode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}

			return root;
		}
		try {
			if (key < root.getKey())
				root.setLeft(this.insertRec(root.getLeft(), newNode));
			else if (key > root.getKey())
				root.setRight(this.insertRec(root.getRight(), newNode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return root;
	}

	/**
	 * Recursively Search in the tree
	 * 
	 * @param key
	 * @return null if not found in tree
	 */
	public Node SearchNode(int key) {
		Node temp = root;
		try {
			while (temp != null) {
				if (temp.getKey() == key) {
					return temp;
				} else if (temp.getKey() > key) {
					temp = temp.getLeft();
				} else if (temp.getKey() < key) {
					temp = temp.getRight();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	/**
	 * Internally calls recursive inorder printing function
	 * 
	 * @param filename
	 * @return List of printing nodes
	 */
	public ArrayList<String> printTree(String filename) {

		try {
			stringList.add(filename);
			inorder(this.root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return stringList;
	}

	/**
	 * recursive function to traverse inorder on tree
	 * 
	 * @param root
	 */
	public void inorder(Node root) {
		if (root != null) {
			try {
				inorder(root.getLeft());
				stringList.add(root.getKey() + " : " + String.join(", ", root.getCourseList()));
				inorder(root.getRight());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
		}
	}

	@Override
	public String toString() {
		return "TreeBuilder [root=" + root + ", stringList=" + stringList + "]";
	}

}
