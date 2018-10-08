package studentCoursesBackup.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.student.Student;

/**
 * FileProcessor class process insert and delete file
 * @author Mehul
 *
 */
public class FileProcessor {
	private File insert;
	private File delete;

	/**
	 * Constructor used to initialize insert and delete file object
	 * @param args
	 */
	public FileProcessor(String[] args) {
		this.insert = new File(args[0]);
		this.delete = new File(args[1]);
	}

	/**
	 * fileInsertExists checks if file insert exists or not
	 * @return
	 */
	public int fileInsertExists() {
		if (!this.insert.exists()) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * fileInsertExists checks if file delete exists or not
	 * @return
	 */
	public int fileDeleteExists() {
		if (!this.delete.exists()) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * fileInsertProcessor process the insert file
	 * @param treeListIn
	 * @return List of original , Backup1 and Backup2 tree by processing insert file
	 */
	public ArrayList<TreeBuilder> fileInsertProcessor(ArrayList<TreeBuilder> treeListIn) {

		Scanner sc;
		try {
			sc = new Scanner(insert);
			while (sc.hasNextLine()) {
				String[] split = sc.nextLine().split(":");
				int key = Integer.parseInt(split[0]);
				String Course = split[1];
				Node searchedNode = treeListIn.get(0).SearchNode(key);
				Node searchedBackup1Node = treeListIn.get(1).SearchNode(key);
				Node searchedBackup2Node = treeListIn.get(2).SearchNode(key);

				if (searchedNode == null) {
					Node originalNode = new Node(key, Course);
					Node backupNode1 = originalNode.clone();
					Node backupNode2 = originalNode.clone();
					originalNode.registerObserver(backupNode1);
					treeListIn.get(0).insert(originalNode);
					backupNode1.setOriginalTree(1);
					treeListIn.get(1).insert(backupNode1);
					backupNode2.setOriginalTree(1);
					treeListIn.get(2).insert(backupNode2);
				} else {
					Student std = new Student(key, Course, "insert");
					searchedNode.update(std);
					searchedBackup1Node.update(std);
					searchedBackup2Node.update(std);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return treeListIn;
	}

	/**
	 * fileDeleteProcessor process the delete file
	 * @param treeListIn
	 * @return List of original , Backup1 and Backup2 tree by processing delete file
	 */
	public ArrayList<TreeBuilder> fileDeleteProcessor(ArrayList<TreeBuilder> treeListIn) {
		Scanner sc;
		try {
			sc = new Scanner(delete);
			while (sc.hasNextLine()) {
				String[] split = sc.nextLine().split(":");
				int key = Integer.parseInt(split[0]);
				String Course = split[1];
				Node searchedNode = treeListIn.get(0).SearchNode(key);
				Node searchedBackup1Node = treeListIn.get(1).SearchNode(key);
				Node searchedBackup2Node = treeListIn.get(2).SearchNode(key);

				if (searchedNode != null) {
					Student std = new Student(key, Course, "remove");
					searchedNode.update(std);
					searchedBackup1Node.update(std);
					searchedBackup2Node.update(std);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return treeListIn;
	}

	@Override
	public String toString() {
		return "FileProcessor [insert=" + insert + ", delete=" + delete + "]";
	}

}
