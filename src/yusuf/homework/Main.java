package yusuf.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.ReverbType;
import javax.swing.text.html.ListView;

public class Main {

	public static void main(String[] args ) throws IOException {
		
		long startTime = System.currentTimeMillis();
		
		int[] data = FileToHeap.readFiles("C:\\Users\\yusufkaradag2\\eclipse-workspace\\Homework\\src\\yusuf\\homework\\abc.txt");
		int [] data2 = FileToHeap.readFiles("C:\\\\Users\\\\yusufkaradag2\\\\eclipse-workspace\\\\Homework\\\\src\\\\yusuf\\\\homework\\\\xyz.txt");
    	//System.out.println(Arrays.toString(data));
    	//System.out.println(data[1]);
    	int n = data.length;
	    FileToHeap.buildHeap(data, n);
		FileToHeap.printHeap(data, n);

		// Start with empty list 
		FileToLList Linked = new FileToLList();
		
		// Use push() to construct below list 1->12->1->4->1
		for (int i = 0; i < data2.length; i++) {
			Linked.push(data2[i]);
		}
		
		int[] copiedArray = new int[data2.length];
		System.arraycopy(data2, 0, copiedArray, 0, data2.length);
		 
		
		Linked.reverse(copiedArray);	
		System.out.println("Array Representation of Linked List is: "+Arrays.toString(copiedArray));
		
		
		for (int i = 0; i < data2.length; i++) {
			System.out.println("Pairwise Product of index " + i + " is " + data[i] * Linked.GetNth(i));
			
			
		}
		
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Elapsed time for whole process: " + timeElapsed + " milliseconds");
		
		File fout = new File("C:\\\\Users\\\\yusufkaradag2\\\\eclipse-workspace\\\\Homework\\\\src\\\\yusuf\\\\homework\\\\out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for (int i = 0; i < data2.length; i++) {
			bw.write(" " + (data[i] * Linked.GetNth(i)));
			bw.newLine();
		}
		bw.write("Elapsed time is: " + timeElapsed + " milliseconds");
	 
		bw.close();
		
		/*Linked.push(1); 
		Linked.push(4); 
		Linked.push(1); 
		Linked.push(12); 
		Linked.push(1); */

		// Check the count function
		//System.out.println(Arrays.deepToString(lList));
		//System.out.println("Element at index 1 is "+ Linked.GetNth(4)); 
		//System.out.println(data[1] * Linked.GetNth(3));
		//System.out.println(FileToHeap.arr);
	}

}
