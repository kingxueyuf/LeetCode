package JumpGame;

public class Solution {
	public boolean canJump(int[] A) {
		boolean[] canJump = new boolean[A.length];
		canJump[0] = true;
		int lastEnd = 0;
		for (int i = 0; i < A.length; i++) {
			if (canJump[i]) {
				if (A[i] + i > lastEnd) {
					for (int j = lastEnd + 1; j <= A[i] + i; j++)
						if (j >= A.length)
							break;
						else {
							canJump[j] = true;
							if (canJump[A.length - 1])
								return true;
						}
					lastEnd = A[i] + i;
				}
			}
		}
		return canJump[A.length - 1];
	}
}