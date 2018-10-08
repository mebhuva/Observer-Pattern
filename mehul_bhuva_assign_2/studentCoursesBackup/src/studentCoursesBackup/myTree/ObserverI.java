package studentCoursesBackup.myTree;

import studentCoursesBackup.student.Student;

/**
 * ObserverInterface have method update to update and delete courses
 * @author Mehul
 *
 */
public interface ObserverI {
	/**
	 * update is used to update and delete courses
	 * @param student
	 */
	public void update(Student student);
}
