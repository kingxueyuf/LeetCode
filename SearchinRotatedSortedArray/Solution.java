package SearchinRotatedSortedArray;

public class Solution {
	public int search(int[] A, int target) {

		if (A == null)
			return -1;
		if (A.length == 0)
			return -1;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return i;
			}
		}
		return -1;

//		int pivot = 0;
//		for (int i = 0; i < A.length - 1; i++) {
//			if (A[i] > A[i + 1]) {
//				pivot = i;
//			}
//		}
//
//		int index = 0;
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] == target) {
//				index = i;
//				if (index > pivot)
//					return index - pivot;
//				else
//					return index + pivot;
//			}
//		}
//		return -1;
	}
}
