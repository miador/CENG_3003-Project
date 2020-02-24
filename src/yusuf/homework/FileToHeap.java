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
	static void heapify(int arr[], int n, int i) {
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
	static void buildHeap(int arr[], int n) {
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

	static void printHeap(int arr[], int n) {
		System.out.println("Array representation of Heap is:");

		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();

	}

}
