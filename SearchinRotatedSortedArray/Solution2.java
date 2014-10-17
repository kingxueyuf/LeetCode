package SearchinRotatedSortedArray;

public class Solution2 {
	public int search(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		int mid = (l + r) / 2;
		if (A.length == 1)
			return (A[0] == target) ? 0 : -1;
		while (l <= r) {
			mid = (l + r) / 2;
			if (A[mid] >= A[l]) {
				if (target < A[mid]) {
					if (target < A[l])
						l = mid + 1;
					else if (target > A[l]) {
						r = mid;
					} else {
						return l;
					}
				} else if (A[mid] < target) {
					l = l + 1;
				} else {// equal
					return mid;
				}
			} else {
				if (target < A[mid]) {
					r = r - 1;
				} else if (target > A[mid]) {
					if (target < A[r])
						l = mid + 1;
					else if (target > A[r])
						r = mid;
					else
						return r;
				} else
					return mid;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		Solution2 s2 = new Solution2();
		int[] A = { 3, 1 };
		System.out.println(s2.search(A, 1));
	}
}
