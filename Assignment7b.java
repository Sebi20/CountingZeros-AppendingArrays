package Assignment7b;

import java.util.*;
import java.io.*;

public class Assignment7b{
	public static void main(String [] args) throws IOException{
		Scanner input = new Scanner(new File("/Users/sebiseb/eclipse-workspace/Assignments/src/Assignment7b/Assignment7bin.txt"));// To read numbers from that file
		PrintWriter output = new PrintWriter("Assignment7bout.txt");// To write data onto that file
		
		int [] numbers = new int[100];// Initialization of the numbers array
		
		output.println("Before Append:");
		int size = readData(numbers, output); // Fills the numbers array with integers from a file.
		output.println("The number of zeros: " + countZeros(numbers, size));// Prints how many numbers have zeros
		
		output.println("-------------------------");
		output.println("After Append:");
		size = append(numbers, size, output);// Fills the numbers array with more numbers
		output.println("The number of zeros after append: " + countZeros(numbers,size));// Prints how many numbers have zeros after append
		
		
		output.close();
	}// End of the main
	
	public static int readData(int [] val, PrintWriter output)throws IOException {
		Scanner input = new Scanner(new File("/Users/sebiseb/eclipse-workspace/Assignments/src/Assignment7b/Assignment7bin.txt"));
		
		int cnt;
		for (cnt = 0; input.hasNext(); cnt++) { // Using a for loop to read in data from a file
			val[cnt] = input.nextInt();// Initializing the numbers in the file to an index of the array
			output.println(val[cnt]);// Printing those numbers found in the array
		}// end of the for loop
		
		output.println("The amount of numbers read in: " + cnt);// Printing how many numbers are in the array
		return cnt;// returning the amount of numbers in the array
	}// End of the readData 
	
	public static int countZeros(int [] val, int n) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (val[i] == 0) {
				cnt++;// Counts all the numbers found in the array that are 0's
			}// end of the if statement
		}// end of the for loop
		
		return cnt;// returning the count of 0's
	}// End of the countZeros
	
	public static int append(int [] val, int n, PrintWriter output) throws IOException{
		Scanner input = new Scanner(new File("append7b.txt"));// Reads data from that file
		int newCnt = 0;
		
		while(input.hasNext()) {//Reads data in until the end of the file
			val[n + newCnt] = input.nextInt();//Adds the data from a file the array
			newCnt++;//Counts how many numbers were added from the file into the array
		}// end of the while
		
		for (int i = 0; i < n + newCnt; i++) { //Scopes through the whole appended array
			output.println(val[i]);// Prints the new list that got appended
		}// End of the for loop
		
		output.println("The number of numbers are now: " + (newCnt + n));// Prints the new count of all he numbers in the new array
		
		return newCnt + n;//Returns the new count of all the numbers in the array
	}// End of the append
}