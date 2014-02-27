package RemoveElement;

import java.util.ArrayList;

public class Solution {
	public int removeElement(int[] A, int elem) {
		int size = A.length;
		for (int i = 0; i < size;) {
			if (A[i] == elem) {
				for(int j  = i  ; j <size-1 ; j++)
				{
					A[j] =A[j+1];
				}
				size--;
			}else
			{
				i++;
			}
		}
		return size;
	}

	public void test() {
		int[] A = { 4, 5 };
		int elem = 4;
		int size = removeElement(A, elem);
		 System.out.println(size);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		// System.out.println(A.length);

	}
}
