package studentCoursesBackup.myTree;

import studentCoursesBackup.student.Student;

public interface SubjectI {
	public void notifyAll(Student student);

    public void registerObserver(Node observer);

    public void removeObserver(Node observer);
}
