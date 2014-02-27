package RemoveDuplicatesfromSortedArray;

public class Solution {
	public int removeDuplicates(int[] A) {
		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return 1;

		int lastPointer = 1;
		int currentPointer = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[currentPointer]) {
				continue;
			} else {
				A[lastPointer] = A[i];
				currentPointer = i;
				lastPointer++;
			}
		}

		return lastPointer;
	}

	public void test() {
		int[] A = { 1, 1, 2 };

		int num = this.removeDuplicates(A);
		System.out.println(num);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}
}
