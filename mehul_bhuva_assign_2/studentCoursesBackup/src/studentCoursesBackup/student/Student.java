package studentCoursesBackup.student;

/**
 * Student class have data fields like bnumber, list of courses and operation
 * @author Mehul
 *
 */
public class Student {
	private int bnumber;
	private String course;

	private String operation;

	/**
	 * Default Constructor
	 */
	public Student() {
	}

	/**
	 * Parameterized Constructor to set all the data fields of student object
	 * @param bnumber
	 * @param course
	 * @param operation
	 */
	public Student(int bnumber, String course, String operation) {
		this.bnumber = bnumber;
		this.course = course;
		this.operation = operation;
	}

	/**
	 * @return bnumber
	 */
	public int getBnumber() {
		return bnumber;
	}

	/**
	 * @param bnumber
	 */
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	/**
	 * @return Course in student object
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * setCourse in student object
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return type of operation
	 */
	public String getOperation() {
		return operation;
	}
	
	/**
	 * use to set student operation
	 * @param operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Student [bnumber=" + bnumber + ", course=" + course + ", operation=" + operation + "]";
	}
}
