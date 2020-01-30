import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		
		int n = 10000000;

		Comparable[] mergeArray = new Comparable[n];
		
		double[] insertArray = new double[n];
		
		for (int i = 0; i < n; i++) {
			mergeArray[i] = (Math.random() * 20);
			insertArray[i] = (Math.random() * 20); }

		long start1 = System.currentTimeMillis();
		insertionSort(insertArray);
		long end1 = System.currentTimeMillis();

		System.out.println("InsertionSort took: " + (end1 - start1) + " milliseconds");

		long start2 = System.currentTimeMillis();
		mergeSort(mergeArray);
		long end2 = System.currentTimeMillis();

		System.out.println("MergeSort took: " + (end2 - start2) + " milliseconds"); }

	public static void insertionSort(double[] n) {

		double temp;
		int i;
		int j;

		for (i = 1; i < n.length; i++) {
			temp = n[i];

			for (j = i-1; (j >= 0) && (n[j] < temp); j--) {
				n[j+1] = n[j]; }

			n[j+1] = temp; }}

	public static void mergeSort(Comparable[] n) {

		Comparable[] temp = new Comparable[n.length];
		doMergeSort(n, temp, 0, n.length - 1); }

	public static void doMergeSort(Comparable[] n, Comparable[] temp, int l, int r) {

		if (l < r) {

			int center = (l + r) / 2;
			doMergeSort(n, temp, l, center);
			doMergeSort(n, temp, center + 1, r);
			applyMergeSort(n, temp, l, center + 1, r); }}

	public static void applyMergeSort(Comparable[] n, Comparable[] temp, int l, int r, int rEnd) {

		int lEnd = r - 1;
		int k = l;
		int num = rEnd - l + 1;

		while (l <= lEnd && r <= rEnd) {
			
			if (n[l].compareTo(n[r]) <= 0) {
				temp[k++] = n[l++]; }
			
			else {
				temp[k++] = n[r++]; }}

		while (l <= lEnd) {    
			temp[k++] = n[l++]; }

		while (r <= rEnd) { 
			temp[k++] = n[r++]; }

		for (int i = 0; i < num; i++, rEnd--) {
			n[rEnd] = temp[rEnd]; }}}



