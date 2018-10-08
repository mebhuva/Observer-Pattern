package studentCoursesBackup.driver;

import java.util.ArrayList;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author John Doe
 *
 */
public class Driver {

	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		} else {
			try {
				FileProcessor fp = new FileProcessor(args);
				int checkinsert = fp.fileInsertExists();// checking if insert file exists or not in the directory
				if (checkinsert == 0) {
					System.out.println("Insert File not found");
					System.exit(0);
				}
				int checkdelete = fp.fileDeleteExists();// checking if delete file exists or not in the directory
				if (checkdelete == 0) {
					System.out.println("Delete File not found");
					System.exit(0);
				}
				
				TreeBuilder originalTree = new TreeBuilder();
				TreeBuilder backUpOneTree = new TreeBuilder();
				TreeBuilder backUpTwoTree = new TreeBuilder();
				ArrayList<TreeBuilder> treeList=new ArrayList<TreeBuilder>();
				treeList.add(originalTree);
				treeList.add(backUpOneTree);
				treeList.add(backUpTwoTree);
				treeList = fp.fileInsertProcessor(treeList);
				treeList = fp.fileDeleteProcessor(treeList);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		}

	}
}
