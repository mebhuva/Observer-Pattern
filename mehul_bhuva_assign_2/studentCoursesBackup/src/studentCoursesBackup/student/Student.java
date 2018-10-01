package studentCoursesBackup.student;

public class Student {
	private int bnumber;
	private String course;

	private String operation;

	public Student() {
	}

	public Student(int bnumber, String course, String operation) {
		this.bnumber = bnumber;
		this.course = course;
		this.operation = operation;
	}

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Student [bnumber=" + bnumber + ", course=" + course + ", operation=" + operation + "]";
	}
}
