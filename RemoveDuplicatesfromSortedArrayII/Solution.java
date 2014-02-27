package RemoveDuplicatesfromSortedArrayII;

public class Solution {
	public int removeDuplicates(int[] A) {

		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
//		if (A.length == 1)
//			return 1;
		int i = 0;
		int currentP = 0;
		int current = 0;

		while (i < A.length) {
			if (i + 1 < A.length && A[i] == A[i + 1]) {
				A[currentP] = A[i];
				A[currentP + 1] = A[i];
				currentP = currentP + 2;
				do {
					i++;
					if (i == A.length - 1)
						break;
				} while (A[i] == A[i + 1]);
				i++;
			} else {
				A[currentP] = A[i];
				currentP++;
				i++;
			}
		}
		return currentP;
	}

	public void test() {
		int[] a = { 1};
		int res = removeDuplicates(a);
		System.out.println(res);
	}
}
