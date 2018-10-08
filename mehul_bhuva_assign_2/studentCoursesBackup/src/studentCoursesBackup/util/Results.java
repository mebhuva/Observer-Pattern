package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results implements  FileDisplayInterface, StdoutDisplayInterface{

	@Override
	public void writeconsole(ArrayList<String> stringList) {
		// TODO Auto-generated method stub
		try {
			for (String objString : stringList) {
				System.out.println(objString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
	}

	@Override
	public void writeFile(ArrayList<String> stringList) {
		// TODO Auto-generated method stub
		BufferedWriter writer = null;
		
		try {
			File file = new File(stringList.get(0));
			writer = new BufferedWriter(new FileWriter(file, true));//using buffered writer to write into the file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		try {
			for (String objString : stringList) {
				try {
					writer.append(objString+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally
				{
					
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		finally
		{
			
		}
		    try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    finally
			{
				
			}
		
	}

}
