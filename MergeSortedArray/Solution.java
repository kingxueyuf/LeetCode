package MergeSortedArray;

public class Solution {

	public void merge(int A[], int m, int B[], int n) {
		if(A ==null || B ==null) return;
		
		int pointA = 0;
		int pointB = 0;
		int i = 0;
		
		while (pointB != n && i != m) {
			if (B[pointB] < A[pointA]) {
				// move every element to in A to next position
				move(A, pointA, m - i);
				A[pointA] = B[pointB];
				pointB++;
				pointA++;
			} else {
				pointA++;
				i++;
			}
		}
		if (pointB == n)
			return;
		else {
			for (int j = pointB; j < n; j++) {
				A[pointA] = B[j];
				pointA++;
			}
		}
	}

	public void move(int[] arr, int start, int length) {
		for (int i = 0; i < length; i++) {
			arr[start + length - i] = arr[start + length - i - 1];
		}
	}

}
