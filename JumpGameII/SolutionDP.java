package JumpGameII;

public class SolutionDP {

	public int jump(int[] A) {
		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return 0;

		int[] steps = new int[A.length];
		steps[0] = 0;

		for (int i = 1; i < A.length; i++) {
			int minSteps = Integer.MAX_VALUE;
			for (int j = i - 1; j > -1; j--) {
				int currentSteps = 0;
				if (i - j <= A[j]) {
					currentSteps = 1 + steps[j];
					if (currentSteps < minSteps) {
						minSteps = currentSteps;
					}
				}
			}
			steps[i] = minSteps;
		}
		return steps[A.length - 1];
	}

	public void test() {
		int[] A = { 222222222, 32, 12, 12, 4 };
		int steps = jump(A);
		System.out.println(steps);
	}
}
