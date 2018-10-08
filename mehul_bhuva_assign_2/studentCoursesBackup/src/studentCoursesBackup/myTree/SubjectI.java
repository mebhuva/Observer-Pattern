package studentCoursesBackup.myTree;

import studentCoursesBackup.student.Student;

/**
 * SubjectInterface have methods like notifyAll , registerObserver and removeObserver
 * @author Mehul
 *
 */
public interface SubjectI {
	/**
	 * notifyAll method is used to notify all listeners
	 * @param student
	 */
	public void notifyAll(Student student);

    /**
     * registerObserver used to register new observer
     * @param observer
     */
    public void registerObserver(Node observer);

    /**
     * removeObserver is used to remove observer
     * @param observer
     */
    public void removeObserver(Node observer);
}
