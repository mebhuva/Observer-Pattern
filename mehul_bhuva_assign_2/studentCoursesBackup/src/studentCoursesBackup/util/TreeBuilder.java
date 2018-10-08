package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {
	Node root;

	public TreeBuilder() {
		root = null;
	}

	private void deleteKey(int key) {
		root = this.deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {
		if (root == null)
			return root;
		if (key < root.getKey())
			root.setLeft(this.deleteRec(root.getLeft(), key));
		else if (key > root.getKey())
			root.setRight(this.deleteRec(root.getRight(), key));
		else {
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			root.setKey(this.minValue(root.getRight()));
			root.setCourseList(this.minValueCourse(root.getRight()));
			root.setRight(this.deleteRec(root.getRight(), root.getKey()));
		}

		return root;
	}

	private ArrayList<String> minValueCourse(Node root) {
		int minv = root.getKey();
		ArrayList<String> temp = root.getCourseList();
		while (root.getLeft() != null) {
			temp = root.getLeft().getCourseList();
			minv = root.getLeft().getKey();
			root = root.getLeft();
		}
		return temp;
	}

	int minValue(Node root) {
		int minv = root.getKey();
		while (root.getLeft() != null) {
			minv = root.getLeft().getKey();
			root = root.getLeft();
		}
		return minv;
	}

	public void insert(Node newNode) {
		root = this.insertRec(root, newNode);
	}

	private Node insertRec(Node root, Node newNode) {
		int key = newNode.getKey();
		if (root == null) {
			root = new Node(newNode);
			return root;
		}
		if (key < root.getKey())
			root.setLeft(this.insertRec(root.getLeft(), newNode));
		else if (key > root.getKey())
			root.setRight(this.insertRec(root.getRight(), newNode));
		return root;
	}

	public Node SearchNode(int key) {
		Node temp = root;
		while (temp != null) {
			if (temp.getKey() == key) {
				return temp;
			} else if (temp.getKey() > key) {
				temp = temp.getLeft();
			} else if (temp.getKey() < key) {
				temp = temp.getRight();
			}
		}
		return null;
	}

	public void deleteCourse(int key, String a_course) {
		Node searchedNode = this.SearchNode(key);
		if (searchedNode != null) {
			if (searchedNode.getCourseList().contains(a_course)) {
				searchedNode.getCourseList().remove(a_course);
			}
		}
	}

}
