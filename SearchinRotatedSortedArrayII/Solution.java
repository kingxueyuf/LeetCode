package SearchinRotatedSortedArrayII;

public class Solution {
	public boolean search(int[] A, int target) {
		
		if(A == null)return false;
		if(A.length ==0)return false;
		
		for(int i =  0 ; i <A.length ; i++)
		{
			if(A[i] == target)
				return true;
		}
		return false;
	}
}
