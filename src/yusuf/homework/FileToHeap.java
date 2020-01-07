package yusuf.homework;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Java program for building Heap from Array 
  
public class FileToHeap { 

	// To heapify a subtree rooted with node i which is 
    // an index in arr[].Nn is size of heap 
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int r = 2 * i + 1; // left = 2*i + 1 
        int l = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If right child is larger than largest so far 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If largest is not root 
        if (largest != i) { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  
    // Function to build a Max-Heap from the Array 
    static void buildHeap(int arr[], int n) 
    { 
        // Index of last non-leaf node 
        int startIdx = (n / 2) - 1; 
  
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = startIdx; i >= 0; i--) { 
            heapify(arr, n, i); 
        } 
    } 
  
    // A utility function to print the array 
    // representation of Heap 
    
    
    static void printHeap(int arr[], int n) 
    { 
    	//int[] copiedArray = new int[n];
        System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " ");
        	
			
        
        System.out.println(); 
        //System.out.println(arr[2]);
        //System.out.println(Arrays.toString(arr));
        //System.arraycopy(arr, 0, copiedArray, 0, 3);
        
    } 
    

  
    // Driver Code 
   /* public static void main(String args[]) throws FileNotFoundException 
    { 
        // Binary Tree Representation 
        // of input array 
        // 1 
        //           /     \ 
        // 3         5 
        //      /    \     /  \ 
        // 4      6   13  10 
        //    / \    / \ 
        // 9   8  15 17 

    	

    	
    	int[] data = readFiles("C:\\Users\\yusufkaradag2\\eclipse-workspace\\Homework\\src\\yusuf\\homework\\abc.txt");
    	System.out.println(Arrays.toString(data));
    	System.out.println(data[1]);
    	int n = data.length;
	    buildHeap(data, n);
		printHeap(data, n);
    	

    	    
        
    }*/

	static int[] readFiles(String file) {
		try {
			
			File f = new File(file);
			Scanner s = new Scanner(f);
			int ctr = 0;
			while (s.hasNext()) {
				ctr++;
				s.nextInt();				
			}
			int[] arr = new int[ctr];
			Scanner s1  = new Scanner(f);
			
			for (int i = 0; i< arr.length; i++) 
				arr[i] = s1.nextInt();
			return arr;
			
			
		} catch (Exception e) {
			return null;
		}		
	} 
} 
