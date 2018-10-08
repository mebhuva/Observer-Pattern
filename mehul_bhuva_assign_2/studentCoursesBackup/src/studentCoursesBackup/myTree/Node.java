package studentCoursesBackup.myTree;

import java.util.ArrayList;

import studentCoursesBackup.student.Student;

/**
 * 
 * Node Class implements  ObserverI, SubjectI and Cloneable to apply observer and mark/tag pattern
 * @author Mehul
 *
 */
public class Node implements ObserverI, SubjectI , Cloneable {
	private int key;
	private ArrayList<String> courseList = new ArrayList<String>();
	private String Course;
	private Node left, right;
	private Node ListnerBackup1;
	private Node ListnerBackup2;
	private String insert = "insert";
	private String remove = "remove";
	int originalTree = 0;

	/**
	 * @return key of current node
	 */
	public int getKey() {
		return key;
	}

	/**
	 * setKey sets key of current node
	 * @param key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return courseList
	 */
	public ArrayList<String> getCourseList() {
		return courseList;
	}

	/**
	 * sets courseList
	 * @param courseList
	 */
	public void setCourseList(ArrayList<String> courseList) {
		this.courseList = courseList;
	}

	/**
	 * @return Course
	 */
	public String getCourse() {
		return Course;
	}

	/**
	 * sets course
	 * @param newCourse
	 */
	public void setCourse(String newCourse) {
		this.Course = newCourse;
	}

	/**
	 * @return leftnode
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * sets left node
	 * @param left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return right node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * sets right node
	 * @param right
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return ListnerBackup1
	 */
	public Node getListnerBackup1() {
		return ListnerBackup1;
	}

	/**
	 * sets ListnerBackup1
	 * @param listnerBackup1
	 */
	public void setListnerBackup1(Node listnerBackup1) {
		ListnerBackup1 = listnerBackup1;
	}

	/**
	 * @return ListnerBackup2
	 */
	public Node getListnerBackup2() {
		return ListnerBackup2;
	}

	/**
	 * sets ListnerBackup2
	 * @param listnerBackup2
	 */
	public void setListnerBackup2(Node listnerBackup2) {
		ListnerBackup2 = listnerBackup2;
	}

	/**
	 * @return insert
	 */
	public String getInsert() {
		return insert;
	}

	/**
	 * sets insert
	 * @param insert
	 */
	public void setInsert(String insert) {
		this.insert = insert;
	}

	/**
	 * @return remove
	 */
	public String getRemove() {
		return remove;
	}

	/**
	 * sets remove
	 * @param remove
	 */
	public void setRemove(String remove) {
		this.remove = remove;
	}

	/**
	 * @return originalTree
	 */
	public int getOriginalTree() {
		return originalTree;
	}

	/**
	 * sets originalTree
	 * @param originalTree
	 */
	public void setOriginalTree(int originalTree) {
		this.originalTree = originalTree;
	}
	
	/**
	 * Default Constructor
	 */
	public Node() {
	}

	/**
	 * Constructor to create node object
	 * @param node
	 */
	public Node(Node node)
	{
		this.key = node.getKey();
		this.left = node.getLeft();
		this.right = node.getRight();
		this.Course = node.getCourse();
		this.courseList.add(this.Course);
		this.originalTree = node.originalTree;
		if(this.originalTree == 0)
		{
			this.ListnerBackup1 = node.getListnerBackup1();
			this.ListnerBackup2 = node.getListnerBackup2();
		}
	}

	/**
	 * This Constructor accepts bnumber and course to generate node object
	 * @param bnumber
	 * @param course
	 */
	public Node(int bnumber, String course) {
		this.key = bnumber;
		this.left = this.right = null;
		this.Course = course;
		this.courseList.add(course);
	}

	@Override
	public void notifyAll(Student student) {
		// TODO Auto-generated method stub
		this.ListnerBackup1.update(student);
		this.ListnerBackup2.update(student);
	}

	@Override
	public void registerObserver(Node observer) {
		// TODO Auto-generated method stub
		this.ListnerBackup1 = observer.clone();
		this.ListnerBackup2 = observer.clone();

	}
	
	@Override
	public void removeObserver(Node observer) {
		// TODO Auto-generated method stub
		ListnerBackup1 = null;
		ListnerBackup2 = null;

	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		String Course = student.getCourse();

		// Below condition is checked to add the courses
		if (student.getOperation().equalsIgnoreCase(insert) && !courseList.contains(Course)) {
			this.courseList.add(Course);
		}

		// Below condition is checked to remove the courses
		if (student.getOperation().equalsIgnoreCase(remove) && courseList.contains(Course)) {
			this.courseList.remove(Course);
		}

		// below condition check if it is original tree node then update the backup node
		if (this.originalTree == 0) {
			this.notifyAll(student);
		}

	}
	
	@Override
	public Node clone()
    {
		Node oldNode = new Node(this.key,this.Course);
		oldNode.originalTree = 1;
         return oldNode;
    }
	
	@Override
	public String toString() {
		return "Node [key=" + key + ", courseList=" + courseList + ", Course=" + Course + ", left=" + left + ", right="
				+ right + ", ListnerBackup1=" + ListnerBackup1 + ", ListnerBackup2=" + ListnerBackup2 + ", insert="
				+ insert + ", remove=" + remove + ", originalTree=" + originalTree + "]";
	}

}