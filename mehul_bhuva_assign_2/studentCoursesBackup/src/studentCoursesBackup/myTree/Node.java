package studentCoursesBackup.myTree;

import java.util.ArrayList;

import studentCoursesBackup.student.Student;

public class Node implements ObserverI, SubjectI {
	private int key;
	private ArrayList<String> courseList = new ArrayList<String>();
	private String Course;
	private Node left, right;
	private Node ListnerBackup1;
	private Node ListnerBackup2;
	private String insert = "insert";
	private String remove = "remove";
	int originalTree = 0;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public ArrayList<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<String> courseList) {
		this.courseList = courseList;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String newCourse) {
		this.Course = newCourse;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getListnerBackup1() {
		return ListnerBackup1;
	}

	public void setListnerBackup1(Node listnerBackup1) {
		ListnerBackup1 = listnerBackup1;
	}

	public Node getListnerBackup2() {
		return ListnerBackup2;
	}

	public void setListnerBackup2(Node listnerBackup2) {
		ListnerBackup2 = listnerBackup2;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getRemove() {
		return remove;
	}

	public void setRemove(String remove) {
		this.remove = remove;
	}

	public int getOriginalTree() {
		return originalTree;
	}

	public void setOriginalTree(int originalTree) {
		this.originalTree = originalTree;
	}
	
	public Node(Node node)
	{
		this.key = node.getKey();
		this.left = node.getLeft();
		this.right = node.getRight();
		this.Course = node.getCourse();
		this.courseList.add(this.Course);
	}

	public Node(int bnumber, String course) {
		this.key = bnumber;
		this.left = this.right = null;
		this.Course = course;
		this.courseList.add(course);
	}

	@Override
	public void notifyAll(Student student) {
		// TODO Auto-generated method stub
		ListnerBackup1.update(student);
		ListnerBackup2.update(student);
	}

	@Override
	public void registerObserver(Node observer) {
		// TODO Auto-generated method stub
		ListnerBackup1 = new Node(observer.getKey(), observer.getCourse());
		ListnerBackup2 = new Node(observer.getKey(), observer.getCourse());

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
}