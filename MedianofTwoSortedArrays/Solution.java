package MedianofTwoSortedArrays;

public class Solution {
	int Alength;
	int Blength;
	public double findMedianSortedArrays(int A[], int B[]) {
		Alength = A.length;
		Blength = B.length;
		int total = A.length + B.length;
		if (total % 2 == 0) {
			return (findKth(A, 0, A.length - 1, B, 0, B.length - 1, total / 2) + findKth(
					A, 0, A.length - 1, B, 0, B.length - 1, total / 2 + 1)) / 2;
		} else {
			return findKth(A, 0, A.length - 1, B, 0, B.length - 1, total / 2);
		}
	}

	private int findKth(int[] a, int aS, int aE, int[] b, int bS, int bE, int k) {
		// TODO Auto-generated method stub
		int aL = aE - aS + 1;
		int bL = bE - bS + 1;
		// assume a is shorter than b
		if (aL > bL) {
			return findKth(b, bS, bE, a, aS, aE, k);
		}
		if (k == 1)
			return Math.min(a[0], b[0]);
		if (aE>=Math.min(Alength, Blength))
			return b[k - 1];
		int pa = Math.min(aL - 1, aS + k / 2);
		int pb = (k - (pa - aS + 1)) + bS - 1;
		if (a[pa] > b[pb]) {
			return findKth(a, aS, aE, b, pb + 1, bE, k - (pb - bS + 1));
		} else if (a[pa] < b[pb]) {
			return findKth(a, pa + 1, aE, b, bS, bE, k - (pa - aS + 1));
		} else {
			return a[pa];
		}
	}
}