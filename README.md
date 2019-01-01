# CSX42: Assignment 2
## Name: Mehul Bhuva

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=input_file.txt -Darg1=delete_file.txt -Darg2=output1_file.txt -Darg3=output2_file.txt -Darg4=output3_file.txt 

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Flow of the project

1. Driver code excepts 5 arguments
2. first two arguments should be two input files input_file.txt and delete_file.txt
3. Next three argument should be the name of output file
4. Driver code than pass the argument to the fileprocessor which checks if file exists in the current directory or not
5. If file found then function fileexists print file not found
6. Driver code then creates three tree original , backup1 and backup2 using TreeBuilder class
7. Driver code then create list of tree and add all three tree in the list
8. Driver code then calls fileprocessor insert and delete fuction to process insert and delete file
9. Driver code then creates object of StdoutDisplayInterface and FileDisplayInterface to print result on console as well as in all three output files 


Time complexity :- O(nlogn) 

## References : 
1. https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/   (To Create BST for TreeBuilder)
2. https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java  (To read File using Scanner)

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 10/08/2018


